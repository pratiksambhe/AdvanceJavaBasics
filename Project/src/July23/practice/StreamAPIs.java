package July23.practice;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamAPIs {
    public static void main(String[] args) {
        List<Integer> l= Arrays.asList(12,3,4,32,2,3,23);

        //Filter
        List<Integer> l2=l.stream().filter(i->i<10).collect(Collectors.toList());
        //l2.forEach(System.out::println);

        //Intermidiate Operations
        //Map
        List<Integer> l3=l.stream().map(i->i+5).collect(Collectors.toList());
     //   l3.forEach(System.out::println);

        //partitioningBy
        Map<Boolean,List<Integer>> l4=l.stream().collect(Collectors.partitioningBy(i->i%2==0));
        System.out.println(l4.get(false));

        //sorted
        List<Integer> l6=l.stream().sorted().collect(Collectors.toList());
      //  l6.forEach(System.out::println);

        //Limit
        List<Integer> l7=l.stream().limit(2).collect(Collectors.toList());
//        l7.forEach(System.out::println);

        //Distinct
        List<Integer> l8=l.stream().distinct().collect(Collectors.toList());
        //l8.forEach(System.out::println);


        //Terminal Operations
        //COUNT
        long l9=l.stream().count();
//        System.out.println(l9);

        //reduce
        Integer l5=l.stream().reduce(0,(a,b)->a+b);
       // System.out.println(l5);

    }
}
