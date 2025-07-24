package org.example.javabased.components;

import org.example.javabased.repo.Animal;
import org.springframework.stereotype.Component;

//@Component
public class Cat implements Animal {
    @Override
    public void info(){
        System.out.println("This is Cat");
    }
}
