package org.example.javabased.components;

import org.example.javabased.repo.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//@Component
public class Pet {
    @Autowired
    @Qualifier("ThisgetCat")  // or "getDog"

    private Animal animal;

    public void petType(){
        animal.info();
    }
}
