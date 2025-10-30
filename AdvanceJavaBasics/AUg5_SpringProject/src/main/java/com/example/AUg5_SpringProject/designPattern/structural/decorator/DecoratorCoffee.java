package com.example.AUg5_SpringProject.designPattern.structural.decorator;

public abstract class DecoratorCoffee implements Coffee {
    Coffee coffee;

    public  DecoratorCoffee(Coffee coffee){
        this.coffee=coffee;
    }

}
