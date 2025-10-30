package com.example.AUg5_SpringProject.Exception;

import com.example.AUg5_SpringProject.Response.ErrorResponseHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(InvalidDataException.class)
    public ResponseEntity<ErrorResponseHandler> invalidDataException(InvalidDataException invalidDataException){
        ErrorResponseHandler responseHandler=new ErrorResponseHandler(HttpStatus.NOT_ACCEPTABLE,"Invalid Data");
      return new ResponseEntity<>(responseHandler,HttpStatus.NOT_IMPLEMENTED);
    }
}
