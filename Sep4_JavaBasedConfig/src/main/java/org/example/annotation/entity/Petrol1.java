package org.example.annotation.entity;

import org.example.annotation.repo.Engine1;
import org.springframework.stereotype.Component;

@Component
public class Petrol1 implements Engine1 {
    @Override
    public void engineType() {
        System.out.println("Petrol Engine");
    }
}
