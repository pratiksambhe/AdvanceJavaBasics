package com.example.AUg5_SpringProject.designPattern.creational.fanctoryMethod;

public class SmsNotifyFactory extends DefaultNotification{
    public Notification sendNotification(){
        return new SmsNotify();
    }
}
