package org.example.configuration;

import org.example.entity.Diesel;
import org.example.entity.Petrol;
import org.example.entity.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public Petrol getPetrol(){
                return new Petrol();
    }

    @Bean
    public Diesel getDiesel(){
        return new Diesel();
    }

    @Bean
    public Vehicle vehicle(){
        return  new Vehicle();
    }
}
