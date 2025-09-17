package com.example.EmailProject.exceptionHandeling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmailSendingException.class)
    public ResponseEntity<Map> EmailSendingException(EmailSendingException emailSendingException){
        HashMap<String, String> map = new HashMap<>();
        map.put("HttpStatus", HttpStatus.NOT_ACCEPTABLE.toString());
        map.put("Message","Mail Cant be send");
        return new ResponseEntity<>(map,HttpStatus.NOT_IMPLEMENTED);
    }

    @ExceptionHandler(EmailReadingException.class)
    public ResponseEntity<Map> EmailReadingException(EmailReadingException emailReadingException){
        HashMap<String, String> map = new HashMap<>();
        map.put("HttpStatus", HttpStatus.NOT_ACCEPTABLE.toString());
        map.put("Message","Mail can't be read");
        return new ResponseEntity<>(map,HttpStatus.NOT_IMPLEMENTED);
    }
}
