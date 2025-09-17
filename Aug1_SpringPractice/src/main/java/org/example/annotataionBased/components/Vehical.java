package org.example.components;

import org.example.repo.Engine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Vehical {

    private Engine engine;
    @Autowired
    public void setEngine(Engine engine){
        this.engine=engine;
    }
    public void engineName(){
        engine.engineType();
    }
}
