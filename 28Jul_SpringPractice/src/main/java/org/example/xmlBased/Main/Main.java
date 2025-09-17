package org.example.xmlBased.Main;

import org.example.xmlBased.components.Vehicle;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ac=new ClassPathXmlApplicationContext("Config1.xml");
        Vehicle v=ac.getBean(Vehicle.class);
        v.engineType();

    }
}
