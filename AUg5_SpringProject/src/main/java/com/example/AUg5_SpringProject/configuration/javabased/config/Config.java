package com.example.AUg5_SpringProject.configuration.javabased.config;

import com.example.AUg5_SpringProject.configuration.javabased.entity.Diesel;
import com.example.AUg5_SpringProject.configuration.javabased.entity.Petrol;
import com.example.AUg5_SpringProject.configuration.javabased.entity.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class Config {

//    @Bean
    public Diesel getDiesel() {
        return new Diesel();
    }

//    @Bean
    public Petrol getPetrol()
    {
        return new Petrol();
    }

//    @Bean
    public Vehicle getVehicle(){
        return new Vehicle();
    }

}
