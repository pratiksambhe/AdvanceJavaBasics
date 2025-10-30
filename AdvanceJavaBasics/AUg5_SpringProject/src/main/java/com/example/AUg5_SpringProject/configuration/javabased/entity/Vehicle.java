package com.example.AUg5_SpringProject.configuration.javabased.entity;

import com.example.AUg5_SpringProject.configuration.javabased.repo.Engine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Vehicle {
    Engine engine;
    @Autowired
    @Qualifier("getDiesel")
    public void setEngine(Engine engine){
        this.engine=engine;
    }

    public void engineInfo(){
        engine.engineType();
    }
}
