package org.example.annotationbased.byclassconfig.components;

import org.example.annotationbased.byclassconfig.repo.Vehical;
import org.springframework.stereotype.Component;

@Component
public class Bike implements Vehical {
public void info(){
    System.out.println("only One can Seat");
}
}
