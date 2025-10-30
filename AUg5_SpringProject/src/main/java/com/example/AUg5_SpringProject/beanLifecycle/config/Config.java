package com.example.AUg5_SpringProject.beanLifecycle.config;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config implements DisposableBean , InitializingBean {

    @Bean
    public Diesel getDiesel() {
        return new Diesel();
    }

    @Bean
    public Petrol getPetrol() {
        return new Petrol();
    }

    @Bean(initMethod = "Initialized",destroyMethod = "destroyed")
    public Vehicle getVehicle() {
        return new Vehicle();
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Bean  ready to Destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Bean ready to initialized");
    }

    @PreDestroy
    public void destroys(){
        System.out.println("Destroy by preDestroy");
    }

    @PostConstruct
    public void initialized(){
        System.out.println("ready to initialized by postConst");
    }
}
