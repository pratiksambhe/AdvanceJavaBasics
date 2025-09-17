package com.example.EmailProject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MailDTO {
    private String subject;
    private List<String> from;
    private List<String> to;
    private Date sentDate;
    private String content;

}
