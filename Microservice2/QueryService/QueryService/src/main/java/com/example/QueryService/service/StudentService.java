package com.example.QueryService.service;

import com.example.QueryService.entity.Students;
import com.example.QueryService.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepo studentRepo;

    public Students getStudentById(Integer id){
        return studentRepo.findById(id).orElseThrow(()->new RuntimeException());
    }

    public List<Students> getAll() {
        return studentRepo.findAll();
    }
}
