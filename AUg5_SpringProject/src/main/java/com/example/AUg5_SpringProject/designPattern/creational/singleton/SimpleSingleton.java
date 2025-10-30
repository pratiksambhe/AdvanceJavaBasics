package com.example.AUg5_SpringProject.designPattern.creational.singleton;

import com.sun.tools.javac.Main;

public class SimpleSingleton {
    private static final SimpleSingleton simpleSingleton=new SimpleSingleton();

    private SimpleSingleton(){

    }
    public static SimpleSingleton getInstance(){
        return simpleSingleton;
    }


    public static void main(String[] args) {
        SimpleSingleton singleton=SimpleSingleton.getInstance();
        SimpleSingleton singleton1=SimpleSingleton.getInstance();
        System.out.println(singleton1==singleton);
    }
}
