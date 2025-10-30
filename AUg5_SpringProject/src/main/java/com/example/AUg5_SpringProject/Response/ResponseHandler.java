package com.example.AUg5_SpringProject.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseHandler <T>{
    private HttpStatus httpStatus;
    private String message;
    private T t;
}
