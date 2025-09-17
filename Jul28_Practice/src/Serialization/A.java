package Serialization;

import java.io.*;

public class A {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
    Person p=new Person(1,"Pratik");
        ObjectOutputStream ob=new ObjectOutputStream(new FileOutputStream("abc.txt"));
        ob.writeObject(p);

        ObjectInputStream i=new ObjectInputStream(new FileInputStream("abc.txt"));
        Person p1=(Person)i.readObject();
        System.out.println(p1);
    }
}
class Person implements Serializable {
    private  int id;
    private String name;
    Person(int id,String name){
        this.id=id;
        this.name=name;

    }
    @Override
    public String toString(){
        return "Person\n{\nid: "+id+"\nname: "+name+"\n}";
    }

}
