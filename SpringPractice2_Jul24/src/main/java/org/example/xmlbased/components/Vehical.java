package org.example.xmlbased.components;

import org.example.xmlbased.repo.Engine;

public class Vehical {
    private Engine engine;
    public void setEngine(Engine engine){
        this.engine=engine;
    }

    public void engineType(){
        engine.engineName();
    }
}
