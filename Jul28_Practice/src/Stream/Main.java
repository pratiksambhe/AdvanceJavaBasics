package Stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> l= Arrays.asList(12,3,1,2,34,34,342);

        List<Integer> l2=l.stream().map(i->i+5).collect(Collectors.toList());
        List<Integer> l3=l.stream().filter(i->i>50).collect(Collectors.toList());
        List<Integer> l4=l.stream().limit(2).collect(Collectors.toList());
        List<Integer> l5=l.stream().distinct().collect(Collectors.toList());
        List<Integer> l6=l.stream().sorted().collect(Collectors.toList());
        long l7=l.stream().count();
        List<Integer> l8=l.stream().map(i->i+5).skip(1).collect(Collectors.toList());
//        System.out.println(l7);
        Map<Boolean,List<Integer>> m1=l.stream().collect(Collectors.partitioningBy(i->i%2==0));
        System.out.println(m1.get(true));
//        l8.forEach(System.out::println);
    }
}
