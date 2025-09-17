package org.example.annotation.entity;

import org.example.annotation.repo.Engine1;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class Diesel implements Engine1 {
    @Override
    public void engineType() {
        System.out.println("Diesel");
    }
}
