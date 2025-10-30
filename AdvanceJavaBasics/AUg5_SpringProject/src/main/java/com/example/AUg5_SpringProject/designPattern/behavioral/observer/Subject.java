package com.example.AUg5_SpringProject.designPattern.behavioral.observer;

public interface Subject {
    public void subscribe(Observer observer);
    public void  unSubscribe(Observer observer);
    public void notifys(String message);
}
