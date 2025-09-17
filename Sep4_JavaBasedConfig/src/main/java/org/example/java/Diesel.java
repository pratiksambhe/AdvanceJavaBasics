package org.example.java;

import org.example.java.Engine;

public class Diesel implements Engine {
    @Override
    public void engineType() {
        System.out.println("Diesel");
    }
}
