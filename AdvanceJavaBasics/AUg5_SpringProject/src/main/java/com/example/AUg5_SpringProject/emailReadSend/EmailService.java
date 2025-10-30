package com.example.AUg5_SpringProject.emailReadSend;


import jakarta.mail.*;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.search.FlagTerm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;


    private Environment environment;
    @Async("threadPoolTaskExecutor")
    public void sendMails(String to) throws MessagingException {

        SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject("first mail");
        simpleMailMessage.setText("ASLKAJLSD");
        javaMailSender.send(sim

                pleMailMessage);

        //Advance way
        MimeMessage message=javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper=new MimeMessageHelper(message,true,"UTF-8");

        mimeMessageHelper.setTo(to);
        String html="<h1>hello world!</h1>"+
                "<img src:'cid:image', alt: Image/>";
        mimeMessageHelper.setText(html,true);
        mimeMessageHelper.setSubject(" ");

        //adding the attachment
        File file=new File("C:\\Users\\Sreenivas Bandaru\\Downloads\\employee_table.pdf");
        ClassPathResource classPathResource=new ClassPathResource("docs/");
        mimeMessageHelper.addAttachment("simple.pdf",classPathResource);

        String htmlImage="<img src:'cid:image', alt: Image/>";
        File file1=new File("C:\\Users\\Sreenivas Bandaru\\Downloads\\ac1.webp");
//        ClassPathResource classPathResource=new ClassPathResource("docs/simple.pdf");
        mimeMessageHelper.addInline("image",file);
        mimeMessageHelper.setText(htmlImage,true);
        javaMailSender.send(message);
    }

    public void readMail() throws MessagingException {
        Properties properties=new Properties();
        properties.put("mail.imap.host","imap.gmail.com");
        properties.put("mail.imap.port","993");
        properties.put("mail.imap.protocol","imaps");

        Session instance = Session.getInstance(properties);
        Store store = instance.getStore();
        store.connect("imap.gmail.com","","");
        Folder inbox = instance.getStore("INBOX").getDefaultFolder();
        int messageCount = inbox.getMessageCount();
        int max = Math.max(messageCount - 5, 1);

        inbox.getMessage(max);

        Message[] messages = inbox.getMessages();
        FlagTerm flagTerm=new FlagTerm(new Flags(Flags.Flag.SEEN),false);
        Message[] search = inbox.search(flagTerm);

        ExecutorService executorService= Executors.newFixedThreadPool(5);

        if(messages.length==0)
        {

        }
        else
        {
            for(int i=0;i< messages.length;i++)
            {
                executorService.submit(new Run(search[i]));
                MimeMessage search1 = (MimeMessage)search[i];
                search1.getMessageNumber();
                String contentType = search1.getContentType();
                if(contentType.equals("Multipart/"));

            }
        }

    }


}

class Run implements  Runnable
{
    private Message message;
    public Run(Message message)
    {
        this.message=message;
    }
    @Override
    public void run() {

    }
}
