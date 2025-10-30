package com.example.AUg5_SpringProject.codeingQue;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Stream2 {
    public static void main(String[] args) {
        List<Integer> l = List.of(1, 2, 3, 4, 45, 2, 3, 54, 2, 12);
        long count = l.stream().filter(i -> i % 5 == 0).count();
//        System.out.println(count);

        List<String> l1 = List.of("aABc", "olrjk", "pratik", "agfug", "pratik", "Sambhe");
        List<String> l2 = l1.stream().map(k -> k.toUpperCase()).collect(Collectors.toList());

        List<String> l3 = l1.stream().map(i -> i.toLowerCase()).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
//        l3.forEach(System.out::println);

        Integer min = l.stream().min(Integer::compareTo).get();

        Map<Boolean, List<Integer>> collect = l.stream().collect(Collectors.partitioningBy(i -> i % 2 == 0));
//        System.out.println(collect.get(true));

        long count1 = l1.stream().filter(i -> i.toLowerCase().startsWith("a")).count();
//        System.out.println(count1);

        Integer i1 = l.stream().filter(i -> i > 10).limit(1).collect(Collectors.toList()).get(0);
//        System.out.println(i1);?

        List<Integer> l4 = l.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
//        System.out.println(l4);

        List<String> l5 = l1.stream().distinct().collect(Collectors.toList());
//        System.out.println(l5);

        emp e = new emp(1, "Pratik", 20203);
        emp e2 = new emp(2, "om", 32000);
        emp e3 = new emp(3, "Anurag", 36000);

        List<emp> l6 = List.of(e, e2, e3);
        emp emp = l6.stream().max(Comparator.comparing(com.example.AUg5_SpringProject.codeingQue.emp::getSalary)).get();
//        System.out.println(emp);

        String s = l1.stream().collect(Collectors.joining(","));
//        System.out.println(s);

        Map<Integer, List<String>> collect1 = l1.stream().collect(Collectors.groupingBy(i -> i.length()));
//        System.out.println(collect1);

        Integer secondLargest = l.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
//        System.out.println(secondLargest);

        String a="hey Buddy Light Weight Baby";
        List<String> l7=List.of(a);
//        l7.stream().collect(Collectors.groupingBy(i->i.))


    }


}

@Data
@AllArgsConstructor
class emp {
    int id;
    String name;
    int salary;
}