package com.example.AUg5_SpringProject.designPattern.creational.fanctoryMethod;

public class EmailNotifyFactory extends DefaultNotification{
    public Notification sendNotification(){
        return new EmailNotify();
    }
}
