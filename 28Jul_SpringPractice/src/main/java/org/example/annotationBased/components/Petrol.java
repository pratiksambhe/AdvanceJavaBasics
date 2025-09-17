package org.example.annotationBased.components;

import org.example.JavaBased.repo.Engine;
import org.springframework.stereotype.Component;

@Component
public class Petrol implements Engine {
    public void info(){
        System.out.println("This is Petrol Engine");
    }
}
