package com.example.ActionService.repo;

import com.example.ActionService.entity.Students;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("QUERYSERVICE")
public interface FeignQuery {
    @GetMapping("/student/getById/{id}")
    public Students getStudentById(@PathVariable Integer id);

}
