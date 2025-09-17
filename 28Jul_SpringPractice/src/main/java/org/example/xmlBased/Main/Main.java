package org.example.JavaBased.Main;

import org.example.JavaBased.components.Vehicle;
import org.example.JavaBased.config.Config;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac=new AnnotationConfigApplicationContext(Config.class);
        Vehicle v=ac.getBean(Vehicle.class);
        v.engineType();
        ac.close();

    }
}
