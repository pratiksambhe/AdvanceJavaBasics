package com.example.AUg5_SpringProject.designPattern.creational.prototype;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")// every time new bean
public class Prototype {
    public Prototype(){
        System.out.println("new obj created");
    }
}
