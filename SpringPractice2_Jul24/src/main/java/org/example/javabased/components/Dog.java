package org.example.javabased.components;

import org.example.javabased.repo.Animal;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//@Primary
//@Component
public class Dog implements Animal {
    @Override
    public void info(){
        System.out.println("This is Dog");
    }
}
