package com.example.EmailProject.service;


import jakarta.mail.Message;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class HnaldeMessage {

    @Async("bean")
    public void read(Message message)
    {

    }
}
