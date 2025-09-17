package org.example.JavaBased.components;

import org.example.JavaBased.repo.Engine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Vehicle {
    @Autowired
    @Qualifier("Petrol")
    private Engine e;
    public void engineType(){
        e.info();
    }
    public void start(){
        System.out.println("start");
    }
    public void end(){
        System.out.println("end");
    }
}
