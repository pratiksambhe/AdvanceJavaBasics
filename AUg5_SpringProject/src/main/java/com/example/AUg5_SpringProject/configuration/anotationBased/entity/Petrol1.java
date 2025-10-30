package com.example.AUg5_SpringProject.configuration.anotationBased.entity;

import com.example.AUg5_SpringProject.configuration.anotationBased.repo.Engine1;
import org.springframework.stereotype.Component;

@Component
public class Petrol1 implements Engine1 {
    public void engineType(){
        System.out.println("Petrol");
    }
}
