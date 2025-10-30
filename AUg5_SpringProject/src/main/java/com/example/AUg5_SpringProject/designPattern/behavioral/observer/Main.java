package com.example.AUg5_SpringProject.designPattern.behavioral.observer;

public class Main {

    public static void main(String[] args) {
        Observer observer1=new Person("pratik");
        Observer observer2=new Person("OM");
        Observer observer3=new Person("Ram");
        YouTube channel=new YouTube();
        channel.subscribe(observer1);
        channel.subscribe(observer2);
        channel.notifys("new song shila added");
        channel.subscribe(observer3);
        channel.notifys("new log added ");
        channel.unSubscribe(observer1);
        channel.notifys("secod song added");
    }
}

