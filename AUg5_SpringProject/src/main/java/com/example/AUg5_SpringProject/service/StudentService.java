package com.example.AUg5_SpringProject.service;

import com.example.AUg5_SpringProject.dto.StudentDTO;
import com.example.AUg5_SpringProject.entityOracle.Student;
import com.example.AUg5_SpringProject.repoOracle.StudentRepo;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private final StudentRepo studentRepo;

    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    //add
    public Student addStudent(StudentDTO studentDTO) {
        Student student = new Student();
        student.setName(studentDTO.getName());
        student.setClgName(studentDTO.getClgName());
        return studentRepo.save(student);
    }

    //add By ModelMapper
    public Student addStudentByMapper(StudentDTO studentDTO) {
        ModelMapper modelMapper = new ModelMapper();

        Student s = modelMapper.map(studentDTO, Student.class);
        return studentRepo.save(s);
    }

    //add By ObjectMapper
    public  Student addStudentByObjectMapper(StudentDTO studentDTO){
        ObjectMapper objectMapper=new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
        Student student = objectMapper.convertValue(studentDTO, Student.class);
        return studentRepo.save(student);
    }
}