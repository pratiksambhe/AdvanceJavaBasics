package com.example.AUg5_SpringProject.Basic.MethodRefrencing;

import java.util.Arrays;
import java.util.List;

public class B {
    public static void sum(int a,int b){
        System.out.println(a+b);
    }

    public static void main(String[] args) {
        A a=B::sum;
        a.add(12,23);

        List<Integer> l= Arrays.asList(12,3,13,313);
        l.forEach(System.out::println);
    }


}
