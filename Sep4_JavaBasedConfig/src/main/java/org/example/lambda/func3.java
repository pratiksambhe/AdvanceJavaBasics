package org.example.lambda;


import java.util.Arrays;
import java.util.List;

public class func3 {


    public static void add(int a, int b) {
        System.out.println(a + b);
    }

    public static void main(String[] args) {


        func a = func3::add;
        List<Integer> l = Arrays.asList(12, 34, 1, 442, 455, 5);


        a.sum(3, 4);
        l.forEach(System.out::print);
    }


}
