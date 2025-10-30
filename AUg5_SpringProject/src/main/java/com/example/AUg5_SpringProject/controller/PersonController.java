package com.example.AUg5_SpringProject.controller;

import com.example.AUg5_SpringProject.Response.ResponseHandler;
import com.example.AUg5_SpringProject.constants.OracleDetails;
import com.example.AUg5_SpringProject.entityMysql.Person;
import com.example.AUg5_SpringProject.service.PersonService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@Slf4j
@RequestMapping("/person")
public class PersonController {
    private final PersonService personService;
    private final OracleDetails o;

    @Value("${spring.mysql.datasource.username}")
    private String username;
    public PersonController(PersonService personService,OracleDetails o) {
        this.personService = personService;
        this.o=o;

    }

    @PostMapping("/add")
    @Operation(summary = "its is to add Person data")
    public ResponseEntity<ResponseHandler> addPerson(@RequestBody Person person) {
        Instant instant = Instant.now(); // 2025-08-06T08:14:30Z
        log.info("oracledetails: {}{}",o.getUsername(),o.getPassword());
        log.info("time: {}", instant);
        log.info("username: {}", username);
        personService.addPerson(person);
        ResponseHandler responseHandler = new ResponseHandler<>(HttpStatus.CREATED, "Data is Added", person);
        return new ResponseEntity<>(responseHandler, HttpStatus.CREATED);
    }

    @GetMapping("/time")
    public void check(){
        LocalDateTime l=LocalDateTime.now();
        DateTimeFormatter d=DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss");
        String date = l.format(d);
        log.info("date:{}",date);
    }
}
