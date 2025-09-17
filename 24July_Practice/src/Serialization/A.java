package Serialization;

import java.io.*;

public class A implements Serializable {
    int id;
    String Name;
    A(int id, String Name){
        this.id=id;
        this.Name=Name;
    }
    public String toString(){
        return " \nPerson {\n id:"+id+"\n Name:"+Name+"\n }";
    }
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        A a=new A(1238,"Pratik");
        ObjectOutputStream o=new ObjectOutputStream(new FileOutputStream("abc.txt"));
        o.writeObject(a);
       o.close();
        ObjectInputStream i=new ObjectInputStream(new FileInputStream("abc.txt"));
        A a2=(A)i.readObject();
        System.out.println(a2);
//        a2.c();
    }
}
