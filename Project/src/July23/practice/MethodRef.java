package July23.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface MethodRef {
    public void m1(int a,int b);
}
class A{
    public static void add(int a,int b){
        System.out.println(a+b);
    }
}
class Main{
    public static void main(String[] args) {
        //First Way
        MethodRef m=A::add;
        m.m1(12,13);

        //Second Way
        List<Integer> a= Arrays.asList(12,3,44,4,2,32,2,23);
        a.forEach(System.out::print );
    }

}