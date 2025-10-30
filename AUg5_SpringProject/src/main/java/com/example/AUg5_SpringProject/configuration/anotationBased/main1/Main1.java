package com.example.AUg5_SpringProject.configuration.anotationBased.main1;

import com.example.AUg5_SpringProject.configuration.anotationBased.config.Config1;
import com.example.AUg5_SpringProject.configuration.anotationBased.entity.Vehicle1;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main1 {
    public static void main(String[] args) {
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(Config1.class);
        Vehicle1 vehicle1 = applicationContext.getBean(Vehicle1.class);
        vehicle1.info();
    }
}
