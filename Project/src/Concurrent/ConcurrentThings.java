package Concurrent;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class ConcurrentThings {
    public static void main(String[] args) {
        ConcurrentHashMap<Integer,String> ch=new ConcurrentHashMap<>();
        ch.put(1,"Pratik");
        ch.put(2,"Rajesh");
        ch.put(3,"Sambhe");
        for(Integer i:ch.keySet()){
            System.out.println(i+" "+ch.get(i));
        }
//        ch.
        CopyOnWriteArrayList<Integer> l=new CopyOnWriteArrayList<>();
        l.add(1);
        l.add(23);

    }
}
