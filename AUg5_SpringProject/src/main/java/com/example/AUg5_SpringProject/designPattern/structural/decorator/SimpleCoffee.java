package com.example.AUg5_SpringProject.designPattern.structural.decorator;

public class SimpleCoffee implements Coffee{
    public String description(){
        return "coffee";
    }
    public Integer cost(){
        return 10;
    }
}
