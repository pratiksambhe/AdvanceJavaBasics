package com.example.AUg5_SpringProject.designPattern.behavioral.observer;

import java.util.ArrayList;
import java.util.List;


public class YouTube implements Subject{

    List<Observer> observers=new ArrayList<>();

    @Override
    public void subscribe(Observer observer) {
        observers.add(observer);
        System.out.println("subscribe by one");
    }
    @Override
    public void unSubscribe(Observer observer){
        System.out.println("unSubscribe by one");
        observers.remove(observer);
    }

    @Override
    public void notifys(String message){
        for(Observer observer:observers){
            observer.updateMsg(message);

        }
    }
}
