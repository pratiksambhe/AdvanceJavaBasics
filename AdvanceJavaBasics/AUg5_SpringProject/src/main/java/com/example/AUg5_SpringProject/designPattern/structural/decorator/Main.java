package com.example.AUg5_SpringProject.designPattern.structural.decorator;

public class Main {
    public static void main(String[] args) {
        Coffee coffee = new SimpleCoffee();
        System.out.println(coffee.description() + " " + coffee.cost());

        coffee = new Milk(coffee);
        System.out.println(coffee.description() + " " + coffee.cost());

        coffee = new Sugar(coffee);
        System.out.println(coffee.description() + " " + coffee.cost());
    }
}
