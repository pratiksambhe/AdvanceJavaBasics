package org.example.java;

import org.example.java.Engine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Vehicle {
    Engine engine;

    @Autowired
    @Qualifier("getPetrol")
    public void setEngine(Engine engine){
        this.engine=engine;
    }

    public void getEngine(){
        engine.engineType();
    }
}
