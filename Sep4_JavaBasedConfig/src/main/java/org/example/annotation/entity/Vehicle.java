package org.example.annotation.entity;

import org.example.annotation.repo.Engine1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Vehicle {
    @Autowired
    private Engine1 engine;

    public void getEngine(){
        engine.engineType();
    }
}
