package Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class A {
    public static void main(String[] args) {
        List<Integer> l= Arrays.asList(12,4,2,1,14,45);
        List<Integer> l2=l.stream().map(i->i+5).collect(Collectors.toList());

        List<Integer> l3=l.stream().filter(i->i<10).collect(Collectors.toList());
        List<Integer> l4=l.stream().map(i->i*10).limit(2).collect(Collectors.toList());

        List<Integer> l5=l.stream().map(i->i+5).sorted().collect(Collectors.toList());
        long l6=l.stream().count();
        System.out.println(l6);
        Map <Boolean,List<Integer>> l7=l.stream().collect(Collectors.partitioningBy(i->i%2==0));
//        l5.forEach(System.out::println);
        System.out.println(l7.get(true));

    }
}
