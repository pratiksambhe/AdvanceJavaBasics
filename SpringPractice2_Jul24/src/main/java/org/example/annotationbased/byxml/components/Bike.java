package org.example.annotationbased.byxml.components;

import org.example.annotationbased.byclassconfig.repo.Vehical;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
@Primary
@Component
public class Bike implements Vehical {
public void info(){
    System.out.println("only One can Seat");
}
}
