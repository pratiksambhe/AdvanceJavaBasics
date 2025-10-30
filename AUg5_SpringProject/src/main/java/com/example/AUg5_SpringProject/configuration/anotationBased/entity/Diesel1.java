package com.example.AUg5_SpringProject.configuration.anotationBased.entity;

import com.example.AUg5_SpringProject.configuration.anotationBased.repo.Engine1;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Diesel1 implements Engine1 {
    @Override
    public void engineType() {
        System.out.println("Diesel");
    }
}
