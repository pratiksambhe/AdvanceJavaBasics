package MethodReferencing;

import java.util.Arrays;
import java.util.List;

public class A {
    public static void sum(int a,int b){
        System.out.println(a+b);
    }

    public static void main(String[] args) {
        B b=A::sum;
        b.add(10,12);

        List<Integer> l= Arrays.asList(12,231,123,13,13,13,3,31);
        l.forEach(System.out::println);
    }
}
