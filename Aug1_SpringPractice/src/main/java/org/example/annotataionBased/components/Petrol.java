package org.example.components;

import org.example.repo.Engine;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Petrol implements Engine {
    public void engineType(){
        System.out.println("It's an Petrol Engine");
    }
}
