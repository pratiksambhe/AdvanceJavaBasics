package com.example.AUg5_SpringProject.designPattern.behavioral.observer;

public class Person implements Observer{
    private String name;

    public Person(String name){
        this.name=name;
    }

    @Override
    public void updateMsg(String message) {
        System.out.println(name+" " +message);
    }



}
