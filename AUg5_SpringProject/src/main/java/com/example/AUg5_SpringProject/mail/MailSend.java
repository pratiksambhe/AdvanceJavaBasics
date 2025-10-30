package com.example.AUg5_SpringProject.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mail")
public class MailSend {

    @Autowired
    JavaMailSender javaMailSender;
    @GetMapping("/send")
    public void mailSend(@RequestParam String to){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setSubject("practice");
        simpleMailMessage.setTo(to);
        simpleMailMessage.setText("Hello BUddy");
        simpleMailMessage.setBcc("shreyashvijaychaudari.eidiko@gmail.com");
        javaMailSender.send(simpleMailMessage);
    }

}
