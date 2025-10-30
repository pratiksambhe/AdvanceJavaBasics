package com.example.AUg5_SpringProject.designPattern.creational.fanctoryMethod;

public class Main {
    public static void main(String[] args) {
        DefaultNotification defaultNotification=new SmsNotifyFactory();
        Notification notification = defaultNotification.sendNotification();
        notification.infoNotify();
    }
}
