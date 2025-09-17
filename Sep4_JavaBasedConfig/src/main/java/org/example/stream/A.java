package org.example.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class A {

    public static void main(String[] args) {
        List<Integer> l= Arrays.asList(12,12,444,4,3,2,5,23,6,7);
        List<Integer> evens = l.stream()
                .filter(i -> i % 2 == 0)
                .collect(Collectors.toList());

        List<String> l2=Arrays.asList("o","abkdg","s;ljd","abc","sdfv");
        List<String> a = l2.stream().filter(i -> i.toUpperCase().startsWith("A")).collect(Collectors.toList());
//        System.out.println(a);
        List<String> collect = l2.stream().map(i -> i.toUpperCase()).collect(Collectors.toList());
//        System.out.println(collect);

        Integer i1 = l.stream().filter(i -> i > 10).collect(Collectors.toList()).get(0);
//        System.out.println(i1);

        List<Integer> collect1 = l.stream().sorted().collect(Collectors.toList());
//        System.out.println(collect1);
        List<Integer> collect2 = l.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
//        System.out.println(collect2);

        Map<Boolean, List<Integer>> collect3 = l.stream().collect(Collectors.partitioningBy(i -> i % 2 == 0));
        //        System.out.println(collect3.get(false));




    }

}
