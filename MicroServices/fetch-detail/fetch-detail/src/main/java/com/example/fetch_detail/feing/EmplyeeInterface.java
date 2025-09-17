package com.example.fetch_detail.feing;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient("QUESTION-SERVICE")
public interface EmplyeeInterface {


    @GetMapping("/getbyId/{id}")
    public void getPerson(@PathVariable Integer id);
}
