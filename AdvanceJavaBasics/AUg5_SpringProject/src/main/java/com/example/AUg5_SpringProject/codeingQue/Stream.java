package com.example.AUg5_SpringProject.codeingQue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Stream {
    public static void main(String[] args) {
        //print all by stream
        List<String> l = List.of("Pratik", "Shubham", "Shreyash");
        l.stream().forEach(System.out::println);


        //cahnge string to uppper by stream
        List<String> l2 = List.of("Shubham", "Pratik", "shreyash", "om");
        List<String> l3 = l2.stream().map(i -> i.toUpperCase()).collect(Collectors.toList());
//        System.out.println(l3);

        //find even Nos
        List<Integer> l4 = List.of(1, 7, 9, 32, 12, 2, 61, 3, 4);
        List<Integer> l5 = l4.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());
//        System.out.println(l5);

        //count no of elements greater than 10
        List<Integer> l6 = List.of(12, 332, 3, 42, 43, 1, 323, 4, 44);
        long c = l6.stream().filter(i -> i > 10).count();
//        System.out.println(c);

        //first element greater than 50
        List<Integer> l7 = List.of(12, 32, 3, 51, 12, 78, 89, 23, 12);
        List<Integer> l8 = l7.stream().filter(i -> i > 50).limit(1).collect(Collectors.toList());
//        System.out.println(l8);

        //sort the list of string
        List<String> l9 = List.of("Pratik", "Shubham", "Shreayash", "om", "Pranav");
        List<String> l10 = l9.stream().sorted().collect(Collectors.toList());
//        System.out.println(l10);

        //remove duplicates from list

        List<Integer> l11 = List.of(12, 3, 32, 321, 3, 31, 33, 31);
        List<Integer> l12 = l11.stream().distinct().toList();
//        System.out.println(l12);

        //find max no in list
        List<Integer> l13 = List.of(12, 122, 1, 4, 123, 2, 343, 23, 4, 2, 43, 2);
        Integer a = l13.stream().sorted(Comparator.reverseOrder()).limit(1).toList().get(0);
//        System.out.println(a);

        //average of list No
        List<Integer> l14 = List.of(12, 4, 3, 44, 5, 6);
        double reduce = l14.stream().mapToInt(Integer::intValue).average().orElse(0.0);
//        System.out.println(reduce);

        //name start with 'A'
        List<String> l15 = List.of("Aaditya", "Om", "Abhishek", "Pratik");
        List<String> l16 = l15.stream().filter(i -> (i.toUpperCase().charAt(0)) == 'A').collect(Collectors.toList());
//        System.out.println(l16);

        //combine words by length
        List<String> l17 = List.of("Pratik", "Pranav", "Om", "Ok");
        Map<Integer, List<String>> collect = l17.stream().collect(Collectors.groupingBy(String::length));
//        System.out.println(collect);

        //no of times a word present
        List<String> l18 = List.of("Om", "Pratik", "Om", "Pranav", "Abhi", "Pratik", "ram", "Pratik");
        Map<String, Long> collect1 = l18.stream().collect(Collectors.groupingBy(i -> i, Collectors.counting()));
//        System.out.println(collect1);

        //even and old
        List<Integer> l19 = List.of(12, 4, 5, 67, 2, 46, 12);
        Map<Boolean, List<Integer>> collect2 = l19.stream().collect(Collectors.partitioningBy(i -> i % 2 == 0));
//        System.out.println(collect2.get(true));

        //top three large no
        List<Integer> l20 = List.of(12, 3, 45, 66, 4, 23, 56);
        List<Integer> collect3 = l20.stream().sorted(Comparator.reverseOrder()).limit(3).collect(Collectors.toList());
//        System.out.println(collect3);

        //join all
        List<String> l21=List.of("Pratik","Om","Pranav");
        String s = l21.stream().collect(Collectors.joining(","));
//        System.out.println(s);


        //skip 1 largest one
        List<Integer> l22=List.of(12,3,4,45,5,54);
        Integer i = l22.stream().sorted(Comparator.reverseOrder()).limit(2).skip(1).collect(Collectors.toList()).get(0);
//        System.out.println(i);

        //reverse sort String List
        List<String> l23=List.of("Pratik","Pranav","Om","Shubham");
        List<String> list = l23.stream().sorted(Comparator.reverseOrder()).toList();
        System.out.println(list);
    }


}

