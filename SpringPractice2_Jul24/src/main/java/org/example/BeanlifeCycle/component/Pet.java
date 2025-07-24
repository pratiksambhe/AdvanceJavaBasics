package org.example.BeanlifeCycle.component;

import org.example.BeanlifeCycle.repo.Animals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Pet {
    public void PetInit(){
        System.out.println("by method i initialize");
    }
    public void PetDestroy(){
        System.out.println("by method destroy");
    }
    @Autowired
    @Qualifier("Cat")
    private Animals a;
    public void petType(){
        a.info();
    }
}
