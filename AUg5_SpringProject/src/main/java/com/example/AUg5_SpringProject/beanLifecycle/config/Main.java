package com.example.AUg5_SpringProject.beanLifecycle.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(Config.class);
        Vehicle vehicle = context.getBean(Vehicle.class);
        vehicle.engineInfo();
        context.close();
    }
}
