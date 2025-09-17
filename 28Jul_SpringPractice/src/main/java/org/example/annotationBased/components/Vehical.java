package org.example.annotationBased.components;

import org.example.JavaBased.repo.Engine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Vehical {
    @Autowired
    private Engine e;

    public void getEngine(){
        e.info();
    }
}
