package org.example.serialization;

import java.io.Serializable;

public class A implements Serializable {

    int age;
    String name;

    public A(int age,String name){
        this.age=age;
        this.name=name;
    }

    public String toString(){
        return "age="+age+"\n name="+name;
    }
}
