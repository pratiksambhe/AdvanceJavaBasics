package org.example.JavaBased.config;

import org.example.JavaBased.components.Diesel;
import org.example.JavaBased.components.Petrol;
import org.example.JavaBased.components.Vehicle;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Configuration
public class Config implements InitializingBean, DisposableBean {
@Bean(name = "Petrol")
    public Petrol getPetrol(){
    return new Petrol();
}
@Bean
    public Diesel getDiesel(){
    return new Diesel();
}
@Bean(initMethod = "start",destroyMethod = "end")
    public Vehicle getVehicle(){
    return  new Vehicle();
}

    @Override
    public void destroy() throws Exception {
        System.out.println("Destroyed");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Initialized");
    }

    @PostConstruct
    public void readyInit(){
        System.out.println("Bean Ready to Initialize");
    }
    @PreDestroy
    public void readyDestroy(){
        System.out.println("Ready to Destroy");
    }

}
