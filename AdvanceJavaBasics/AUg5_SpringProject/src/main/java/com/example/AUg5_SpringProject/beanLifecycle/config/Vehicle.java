package com.example.AUg5_SpringProject.beanLifecycle.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Vehicle {
    Engine engine;

    @Autowired
    @Qualifier("getPetrol")
    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void engineInfo() {
        engine.engineType();
    }
    public void Initialized(){
        System.out.println("Initialized");
    }
    public void destroyed(){
        System.out.println("destroyed");
    }
}
