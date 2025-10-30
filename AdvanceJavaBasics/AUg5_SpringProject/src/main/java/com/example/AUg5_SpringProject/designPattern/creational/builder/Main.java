package com.example.AUg5_SpringProject.designPattern.creational.builder;

public class Main {
    public static void main(String[] args) {
        User user = new User.Builder().setId(1).setAddress("amt").setName("Pratik").build();
        System.out.println(user);

        User1 om = User1.builder().id(2).name("Om").build();
        System.out.println(om);
    }
}
