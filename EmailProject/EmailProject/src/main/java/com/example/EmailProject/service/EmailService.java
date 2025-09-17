package com.example.EmailProject.service;

import com.example.EmailProject.configuration.ConfigMailReader;
import com.example.EmailProject.dto.MailDTO;
import com.example.EmailProject.exceptionHandeling.EmailReadingException;
import com.example.EmailProject.exceptionHandeling.EmailSendingException;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.search.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.logging.Log;
import org.apache.logging.log4j.util.PropertySource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.comparator.Comparators;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

@Service
@Slf4j
@Scope(value = "prototype")
public class EmailService {
    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private ConfigMailReader configMailReader;

    @Autowired
    private HnaldeMessage hnaldeMessage;
    @Async("threadPoolTaskExecutor")
    public void sendMail(String to, String cc, String bcc, String subject, String htmlContent, MultipartFile file) {

        if (to == null) {
            throw new EmailSendingException();
        }

        try {
            // Create MimeMessage
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();

            // Enable multipart (true) for attachments
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

            // Basic mail info
            helper.setTo(to);

            if (cc != null && !cc.isEmpty()) {
                helper.setCc(cc);
            }
            if (bcc != null && !bcc.isEmpty()) {
                helper.setBcc(bcc);
            }

            helper.setSubject(subject);

            // For HTML content, pass `true`
//            helper.setText(htmlContent, true);

            helper.setText(htmlContent);
            // Attachment (optional)

            if (file != null && !file.isEmpty()) {
                helper.addAttachment(file.getOriginalFilename(), file);
            }

            // Send email
            javaMailSender.send(mimeMessage);
            log.info("Mail sent to {} with subject '{}'", to, subject);

        } catch (MessagingException e) {
            log.error("Error while sending email: {}", e.getMessage(), e);
        }
    }

    @Async("threadPoolTaskExecutor")
    public String readMail(int count, String type) throws Exception {
        Properties properties = new Properties();
        properties.setProperty("mail.imap.port", String.valueOf(configMailReader.getPort()));
        properties.setProperty("mail.store.protocol", configMailReader.getProtocol());
        properties.setProperty("mail.imap.ssl.enable", String.valueOf(configMailReader.getSslEnable()));
        properties.setProperty("mail.imap.host", configMailReader.getHost());

        Session session = Session.getDefaultInstance(properties);
        Store store = session.getStore(configMailReader.getProtocol());
        store.connect(configMailReader.getHost(), configMailReader.getUser(), configMailReader.getPassword());

        Folder inbox = store.getFolder("INBOX");
        inbox.open(Folder.READ_ONLY);

        Message[] messages;

        switch (type.toLowerCase()) {
            case "unseen": {
                Flags seen = new Flags(Flags.Flag.SEEN);
                FlagTerm unseenFlagTerm = new FlagTerm(seen, false);
                messages = inbox.search(unseenFlagTerm);
                break;
            }
            case "recent": {
                messages = inbox.getMessages();
                Arrays.sort(messages, Comparator.comparingInt(Message::getMessageNumber).reversed());
                // newest first based on message number
                break;
            }
            case "old": {
                messages = inbox.getMessages();
                Arrays.sort(messages, Comparator.comparingInt(Message::getMessageNumber));

                break;
            }
            case "recentunseen": {
                Flags seen = new Flags(Flags.Flag.SEEN);
                FlagTerm unseenFlagTerm = new FlagTerm(seen, false);
                messages = inbox.search(unseenFlagTerm);
                Arrays.sort(messages, Comparator.comparingInt(Message::getMessageNumber).reversed());
                // unseen sorted by recent
                break;
            }
            default:
                throw new IllegalArgumentException("Invalid type: " + type + ". Use unseen/recent/old/recentunseen");
        }


        // limit to 'count'
        int limit = Math.min(count, messages.length);
        Message[] finalMessages = Arrays.copyOfRange(messages, 0, limit);

        StringBuilder sb = new StringBuilder();
        for (Message msg : finalMessages) {
            sb.append("From: ").append(Arrays.toString(msg.getFrom())).append("\n")
                    .append("Subject: ").append(msg.getSubject()).append("\n")
                    .append("Date: ").append(msg.getReceivedDate()).append("\n\n");
        }
        inbox.close(false);
        store.close();
        System.out.println(sb.toString());
        return sb.toString();
    }

    @Async("threadPoolTaskExecutor")
    public List<MailDTO> filterMails(String subject, Date fromDate, Date toDate, String receiver)
            throws MessagingException, IOException {

        // -------------------------------
        // Validate dates
        // -------------------------------
        Date now = new Date();
        if (fromDate != null && toDate != null && fromDate.after(toDate)) {
            throw new EmailReadingException("From date cannot be after To date");
        }
        if (fromDate != null && fromDate.after(now)) {
            throw new EmailReadingException("From date cannot be in the future");
        }
        if (toDate != null && toDate.after(now)) {
            throw new EmailReadingException("To date cannot be in the future");
        }

        // -------------------------------
        // Mail session setup
        // -------------------------------
        Properties properties = new Properties();
        properties.setProperty("mail.imap.port", String.valueOf(configMailReader.getPort()));
        properties.setProperty("mail.store.protocol", configMailReader.getProtocol());
        properties.setProperty("mail.imap.ssl.enable", String.valueOf(configMailReader.getSslEnable()));
        properties.setProperty("mail.imap.host", configMailReader.getHost());

        Session session = Session.getDefaultInstance(properties);
        Store store = session.getStore(configMailReader.getProtocol());
        store.connect(configMailReader.getHost(), configMailReader.getUser(), configMailReader.getPassword());

        Folder inbox = store.getFolder("INBOX");
        inbox.open(Folder.READ_ONLY);

        // -------------------------------
        // Build SearchTerms
        // -------------------------------
        List<SearchTerm> terms = new ArrayList<>();

        if (subject != null && !subject.isEmpty()) {
            terms.add(new SubjectTerm(subject));
        }
        if (receiver != null && !receiver.isEmpty()) {
            terms.add(new RecipientTerm(Message.RecipientType.TO, new InternetAddress(receiver)));
        }
        if (fromDate != null) {
            terms.add(new SentDateTerm(ComparisonTerm.GE, fromDate));
        }
        if (toDate != null) {
            terms.add(new SentDateTerm(ComparisonTerm.LE, toDate));
        }

        SearchTerm finalTerm = null;
        if (!terms.isEmpty()) {
            finalTerm = new AndTerm(terms.toArray(new SearchTerm[0]));
        }

        // -------------------------------
        // Apply SearchTerm
        // -------------------------------
        Message[] messages = (finalTerm != null) ? inbox.search(finalTerm) : inbox.getMessages();

        // -------------------------------
        // Multithread processing of results
        // -------------------------------
        ExecutorService service = Executors.newFixedThreadPool(10);
        List<Future<MailDTO>> futures = new ArrayList<>();

        for (Message message : messages) {
            hnaldeMessage.read(message);

            Multipart content =(Multipart) message.getContent();
            for(int i=0;i<content.getCount();i++)
            {
                BodyPart bodyPart = content.getBodyPart(i);
                if(bodyPart.isMimeType("multipart/*"))
                {
                    String disposition = bodyPart.getDisposition();
                    if(disposition!=null)
                    {
                        if(Part.ATTACHMENT.equalsIgnoreCase(disposition) && bodyPart.getContentType().startsWith("applicaion/pdf"))
                        {

                        }
                    }
                }
            }
            futures.add(service.submit(() -> {
                MailDTO dto = new MailDTO();
                dto.setSubject(message.getSubject());
                dto.setFrom(Collections.singletonList(Arrays.toString(message.getFrom())));
                dto.setSentDate(message.getSentDate());
                return dto;
            }));
        }

        List<MailDTO> filtered = new ArrayList<>();
        for (Future<MailDTO> f : futures) {
            try {
                filtered.add(f.get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        inbox.close(false);
        store.close();
        service.shutdown();

        return filtered;
    }



}