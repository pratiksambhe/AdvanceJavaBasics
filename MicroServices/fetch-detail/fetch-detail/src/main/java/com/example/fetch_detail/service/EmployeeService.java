package com.example.fetch_detail.service;

import com.example.fetch_detail.entity.Employee;
import com.example.fetch_detail.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;

    public void addEmployee(Employee employee){
        employeeRepo.save(employee);
    }

}
