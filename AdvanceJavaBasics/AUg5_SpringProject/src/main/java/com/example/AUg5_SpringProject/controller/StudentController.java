package com.example.AUg5_SpringProject.controller;

import com.example.AUg5_SpringProject.dto.StudentDTO;
import com.example.AUg5_SpringProject.entityOracle.Student;
import com.example.AUg5_SpringProject.service.StudentService;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;
    public StudentController(StudentService studentService){
        this.studentService=studentService;
    }

    //add
    @PostMapping("/add")
    public Student addStudent(@RequestBody StudentDTO studentDTO){
        return studentService.addStudent(studentDTO);
    }

    //add By ModelMapper
    @PostMapping("/addByMapper")
    public Student addStudentByMapper(@RequestBody StudentDTO studentDTO) {
        return studentService.addStudentByMapper(studentDTO);
    }

    //add By ObjectMapper
    @PostMapping("/addByObjectMapper")
    public  Student addStudentByObjectMapper(@RequestBody StudentDTO studentDTO){
        return studentService.addStudentByObjectMapper(studentDTO);
    }

}
