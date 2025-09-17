package org.example.annotationBased.entity;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Animal implements Organism{
    public void infoOrganism(){
        System.out.println("Animal");
    }
}
