package org.example.annotationbased.byclassconfig.components;

import org.example.annotationbased.byclassconfig.repo.Vehical;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
@Primary
@Component
public class XlCar implements Vehical {
    public void info(){
        System.out.println("5 Person Can Seat");
    }
}
