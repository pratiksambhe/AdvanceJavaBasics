package com.example.AUg5_SpringProject.designPattern.structural.decorator;

public class Sugar extends DecoratorCoffee{

    public Sugar(Coffee coffee){
        super(coffee);
    }

    public String description(){
        return coffee.description()+ " with sugar";
    }

    public Integer cost(){
        return coffee.cost()+5;
    }
}
