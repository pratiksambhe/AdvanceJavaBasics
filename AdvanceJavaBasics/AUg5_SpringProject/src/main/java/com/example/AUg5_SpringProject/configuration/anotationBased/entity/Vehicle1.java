package com.example.AUg5_SpringProject.configuration.anotationBased.entity;

import com.example.AUg5_SpringProject.configuration.anotationBased.repo.Engine1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Vehicle1 {
    Engine1 engine1;

    @Autowired
    public void setEngine1(Engine1 engine1){
        this.engine1=engine1;
    }

    public void info(){
        engine1.engineType();
    }
}
