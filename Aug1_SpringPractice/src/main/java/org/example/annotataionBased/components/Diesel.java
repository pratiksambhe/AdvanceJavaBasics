package org.example.components;

import org.example.repo.Engine;
import org.springframework.stereotype.Component;

@Component
public class Diesel implements Engine {
    public void engineType(){
        System.out.println("It's an diesel engine");
    }
}
