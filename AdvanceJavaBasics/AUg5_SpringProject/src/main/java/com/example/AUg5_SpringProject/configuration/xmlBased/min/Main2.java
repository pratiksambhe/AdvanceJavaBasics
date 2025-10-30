package com.example.AUg5_SpringProject.configuration.xmlBased.min;

import com.example.AUg5_SpringProject.configuration.xmlBased.entity.Vehicle3;
import org.springframework.context.ApplicationContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main2 {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("config.xml");
        Vehicle3 bean = context.getBean(Vehicle3.class);
        bean.info();
    }
}
