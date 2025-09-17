package com.example.ActionService.controller;

import com.example.ActionService.dto.StudnetDto;
import com.example.ActionService.entity.Students;
import com.example.ActionService.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/addStudent")
    public Students addStudent(@RequestBody StudnetDto studnetDto) {
        return studentService.addStudent(studnetDto);
    }

    @PutMapping("/update/{id}/{city}")
    public Students updateCityStudentById(@PathVariable Integer id, @PathVariable String city) {
        return studentService.updateCityStudentByName(id, city);
    }

    @PutMapping("/updateById/{id}")
    public Students updateStudentById(@PathVariable Integer id, @RequestBody StudnetDto studnetDto) {
        return studentService.updateStudentById(id, studnetDto);
    }

    @GetMapping("/getByRestTemplete/{id}")
    public Students getByRestTemplete(@PathVariable Integer id) {
        return studentService.getByRestTemplete(id);
    }

    @GetMapping("/getByWebClient/{id}")
    public Students getByWebClient(@PathVariable Integer id) {
        return studentService.getByWebClient(id);
    }
}
