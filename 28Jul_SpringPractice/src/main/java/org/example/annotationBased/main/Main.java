package org.example.annotationBased.main;

import org.example.JavaBased.components.Vehicle;
import org.example.annotationBased.Config.Config;
import org.example.annotationBased.components.Vehical;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ac=new ClassPathXmlApplicationContext("Config.xml");
        Vehical v=ac.getBean(Vehical.class);
        v.getEngine();
    }
}
