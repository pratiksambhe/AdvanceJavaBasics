package org.example.xml;

import netscape.security.UserTarget;
import org.springframework.beans.factory.annotation.Autowired;

public class Vehicle {
    private Engine engine;
    @Autowired
    public void setEngine(Engine engine){
        this.engine=engine;
    }
    public void getEngine(){
        engine.engineType();
    }
}
