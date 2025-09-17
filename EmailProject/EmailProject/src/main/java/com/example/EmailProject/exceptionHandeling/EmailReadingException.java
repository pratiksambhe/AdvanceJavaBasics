package com.example.EmailProject.exceptionHandeling;

import com.example.EmailProject.controller.EmailController;

public class EmailReadingException extends RuntimeException{
    public EmailReadingException(String message){
        super(message);
    }
}
