package org.example.xmlBased.components;

import org.example.xmlBased.repo.Engine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Vehicle {
    private Engine e;
    public void setE(Engine e){
        this.e=e;
    }
    public void engineType(){
        e.info();
    }

}
