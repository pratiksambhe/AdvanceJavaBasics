package org.example.annotationBased.entity;

import org.springframework.stereotype.Component;

@Component
public class Plant implements Organism{
    public void infoOrganism(){
        System.out.println("This is Plant");
    }
}
