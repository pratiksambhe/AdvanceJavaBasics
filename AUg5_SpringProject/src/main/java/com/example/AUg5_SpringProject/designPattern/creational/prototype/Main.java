package com.example.AUg5_SpringProject.designPattern.creational.prototype;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class Main {
    public static void main(String[] args) throws Exception {
        ApplicationContext context=new AnnotationConfigApplicationContext(Prototype.class);
        Prototype prototype=context.getBean(Prototype.class);
        Prototype prototype1=context.getBean(Prototype.class);

    }
}
