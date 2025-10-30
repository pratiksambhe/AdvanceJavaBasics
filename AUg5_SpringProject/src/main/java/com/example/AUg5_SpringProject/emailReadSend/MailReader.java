package com.example.AUg5_SpringProject.emailReadSend;

import jakarta.mail.Folder;
import jakarta.mail.Message;
import jakarta.mail.Session;
import jakarta.mail.Store;
import jakarta.mail.search.ComparisonTerm;
import jakarta.mail.search.ReceivedDateTerm;
import jakarta.mail.search.SearchTerm;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.*;

@RestController
public class MailReader {

    String host = "imap.gmail.com";
    String username = "pratiksambhe.eidiko@gmail.com";
    String password = "qtfaqqivvkvkffjt";

    @GetMapping("/get")
    public String mailReader() {

        try {
            // Set properties
            Properties properties = new Properties();
            properties.put("mail.store.protocol", "imaps");
            properties.put("mail.imaps.host", host);
            properties.put("mail.imaps.port", "993");
            properties.put("mail.imaps.ssl.enable", "true");

            // Create session
            Session session = Session.getDefaultInstance(properties);

            // Get the store
            Store store = session.getStore("imaps");
            store.connect(host, username, password);

            // Get inbox folder
            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_ONLY);

            // Get messages
            Message[] messages = inbox.getMessages();

            StringBuilder builder = new StringBuilder();
            builder.append("Total messages: ").append(messages.length).append("<br>");

            // Read last 5 emails
            int start = Math.max(1, messages.length - 5);
            for (int i = start; i <= messages.length; i++) {
                Message msg = messages[i - 1];
                builder.append("Subject: ").append(msg.getSubject()).append("<br>");
                builder.append("From: ").append(msg.getFrom()[0]).append("<br><br>");
            }

            inbox.close(false);
            store.close();

            return builder.toString();

        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to read emails: " + e.getMessage();
        }
    }

    @GetMapping("/read-mails-byDate")
    public List<Map<String, Object>> readMailsByDate(@RequestParam String date) {
        List<Map<String, Object>> result = new ArrayList<>();

        try {
            // Gmail IMAP Properties
            Properties properties = new Properties();
            properties.put("mail.store.protocol", "imaps");
            properties.put("mail.imaps.host", host);
            properties.put("mail.imaps.port", "993");
            properties.put("mail.imaps.ssl.enable", "true");

            Session session = Session.getInstance(properties, null);
            Store store = session.getStore("imaps");
            store.connect(host, username, password);

            // Open inbox
            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_ONLY);

            // Parse input date
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            Date searchDate = sdf.parse(date);

            // Search mails newer than given date
            SearchTerm newerThan = new ReceivedDateTerm(ComparisonTerm.GT, searchDate);
            Message[] messages = inbox.search(newerThan);

            for (Message message : messages) {
                Map<String, Object> mailData = new LinkedHashMap<>();
                mailData.put("subject", message.getSubject() != null ? message.getSubject() : "(No Subject)");
                mailData.put("from", (message.getFrom() != null && message.getFrom().length > 0)
                        ? message.getFrom()[0].toString()
                        : "(Unknown)");
                mailData.put("receivedDate", message.getReceivedDate());

                result.add(mailData);
            }

            inbox.close(false);
            store.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result; // Spring auto-converts List<Map> to JSON
    }

    @GetMapping("/emails")
    public List<Map<String, Object>> fetchEmails(
            @RequestParam(defaultValue = "INBOX") String folderName) {

        List<Map<String, Object>> emails = new ArrayList<>();

        try {
            Properties props = new Properties();
            props.put("mail.store.protocol", "imaps");
            props.put("mail.imaps.host", host);
            props.put("mail.imaps.port", "993");
            props.put("mail.imaps.ssl.enable", "true");

            Session session = Session.getInstance(props, null);
            Store store = session.getStore("imaps");
            store.connect(host, username, password);

            Folder mailFolder = store.getFolder(folderName);
            if (mailFolder == null || !mailFolder.exists()) {
                throw new RuntimeException("Folder not found: " + folderName);
            }
            mailFolder.open(Folder.READ_ONLY);

            Message[] messages = mailFolder.getMessages();

            for (Message msg : messages) {
                Map<String, Object> emailData = new LinkedHashMap<>();
                emailData.put("subject", msg.getSubject() != null ? msg.getSubject() : "(No Subject)");
                emailData.put("from", (msg.getFrom() != null && msg.getFrom().length > 0)
                        ? msg.getFrom()[0].toString()
                        : "(Unknown Sender)");
                emailData.put("receivedDate", msg.getReceivedDate());

                emails.add(emailData);
            }

            mailFolder.close(false);
            store.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return emails;
    }


}

