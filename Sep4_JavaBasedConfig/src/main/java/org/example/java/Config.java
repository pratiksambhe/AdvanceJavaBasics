package org.example.java;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Configuration
public class Config implements InitializingBean, DisposableBean {

    @Bean
    public Petrol getPetrol(){
        return new Petrol();
    }

    @Bean
    public  Diesel getDiesel(){
        return new Diesel();
    }

    @Bean
    public Vehicle getVehicle(){
        return new Vehicle();
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("ready to destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("ready to initialized");
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("ready to destroy");
    }

    @PostConstruct
    public void postDestroy(){
        System.out.println("ready to Destroy");
    }
}
