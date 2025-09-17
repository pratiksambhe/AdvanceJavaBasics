package Serialization;

import com.sun.xml.internal.ws.developer.Serialization;

import java.io.*;

import static sun.plugin2.liveconnect.ArgumentHelper.readObject;

public class Person implements Serializable {
int id;
String name;
public  Person(int id,String name){
    this.id=id;
    this.name=name;
}

    @Override
    public String toString() {
        return "Person{"+"\nid: "+id+"\n"+"name: "+name+"}";
    }

    public static void main(String[] args) {
    Person p=new Person(1,"Pratik");

        try (ObjectOutputStream ob=new ObjectOutputStream(new FileOutputStream("C:\\Users\\Sreenivas Bandaru\\Desktop\\java\\my.ser"
                ));
        ){
            ob.writeObject(p);
        } catch (IOException e) {
            System.out.println(e);
        }
        try(ObjectInputStream ob1=new ObjectInputStream(new FileInputStream("C:\\Users\\Sreenivas Bandaru\\Desktop\\java\\my.ser"));
        ) {

                Person p1=(Person)ob1.readObject();
            System.out.println(p1);
            } catch (ClassNotFoundException |IOException e1) {

        }
    }
}
