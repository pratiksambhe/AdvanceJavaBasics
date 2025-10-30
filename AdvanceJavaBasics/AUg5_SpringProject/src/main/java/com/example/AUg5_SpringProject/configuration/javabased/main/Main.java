package com.example.AUg5_SpringProject.configuration.javabased.main;


import com.example.AUg5_SpringProject.configuration.javabased.config.Config;
import com.example.AUg5_SpringProject.configuration.javabased.entity.Vehicle;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//add the context dependency
public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(Config.class);
        Vehicle vehicle = applicationContext.getBean(Vehicle.class);
        vehicle.engineInfo();
    }
}
