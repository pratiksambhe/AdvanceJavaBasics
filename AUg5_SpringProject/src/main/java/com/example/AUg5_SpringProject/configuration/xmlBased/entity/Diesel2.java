package com.example.AUg5_SpringProject.configuration.xmlBased.entity;

import com.example.AUg5_SpringProject.configuration.xmlBased.repo.Engine2;

public class Diesel2 implements Engine2 {
    @Override
    public void engineType() {
        System.out.println("Diesel");
    }
}
