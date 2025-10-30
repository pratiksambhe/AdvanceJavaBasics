package com.example.AUg5_SpringProject.designPattern.structural.decorator;

public class Milk extends DecoratorCoffee{
    public Milk(Coffee coffee){
        super(coffee);
    }

    public String description(){
        return coffee.description()+" with milk";
    }
    public Integer cost(){
        return coffee.cost()+15;
    }

}
