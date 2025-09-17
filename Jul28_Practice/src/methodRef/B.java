package methodRef;

import java.util.Arrays;
import java.util.List;

public class B {
    public static void sum(int a,int b )
    {
        System.out.println(a+b);

    }}
class Main{
    public static void main(String[] args) {
        A a=B::sum;
        a.add(12,13);

        List<Integer> l= Arrays.asList(12,13,12,2,12,2);
        l.forEach(System.out::println);
    }
}
