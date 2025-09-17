package org.example.annotationBased.components;

import org.example.JavaBased.repo.Engine;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Diesel implements Engine {
    @Override
    public void info() {
        System.out.println("This is Diesel Engine");
    }
}
