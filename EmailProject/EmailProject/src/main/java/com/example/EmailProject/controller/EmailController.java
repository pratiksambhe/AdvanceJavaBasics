package com.example.EmailProject.controller;

import com.example.EmailProject.dto.MailDTO;
import com.example.EmailProject.service.EmailService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/mail")
public class EmailController {
    @Autowired
    private EmailService emailService;


    @PostMapping("/sendTo")
    public String sendMail(
            @RequestParam(required = false)  String to,
            @RequestParam(required = false) String cc,
            @RequestParam(required = false) String bcc,
            @RequestParam String subject,
            @RequestParam String body,
            @RequestParam(required = false) MultipartFile file) {


        emailService.sendMail(to, cc, bcc, subject, body, file);

        return "Mail sent successfully to " + to;
    }

    @GetMapping("/readMail")
    public String readMail(@RequestParam int count, @RequestParam String type) throws Exception {
        return emailService.readMail(count, type);

    }

    @GetMapping("/getMail")
    public List<MailDTO> filterMails(@RequestParam(required = false) String subject,
                                     @RequestParam(required = false)  @DateTimeFormat(pattern = "yyyy-MM-dd") Date fromDate,
                                     @RequestParam(required = false)  @DateTimeFormat(pattern = "yyyy-MM-dd") Date toDate,
                                     @RequestParam(required = false) String receiver) throws MessagingException, IOException {
        return emailService.filterMails(subject, fromDate, toDate, receiver);
    }

}
