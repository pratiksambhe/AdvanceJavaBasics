package com.example.AUg5_SpringProject.configuration.xmlBased.entity;

import com.example.AUg5_SpringProject.configuration.xmlBased.repo.Engine2;
import org.springframework.beans.factory.annotation.Autowired;

public class Vehicle3  {

    Engine2 engine2;

    @Autowired
    public void setEngine2(Engine2 engine2){
        this.engine2=engine2;
    }

    public void  info(){
        engine2.engineType();
    }
}
