package org.example.serialization;

import java.io.*;

public class B {
    public static void main(String[] args) throws IOException {
        A a=new A(1,"Om");
        try(ObjectOutputStream o=new ObjectOutputStream(new FileOutputStream("output.txt"))){
            o.writeObject(a);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try(ObjectInputStream i=new ObjectInputStream(new FileInputStream("C:\\Users\\Sreenivas Bandaru\\IdeaProjects\\Sep4_JavaBasedConfig\\output.txt"))){
            A b = (A) i.readObject();
            System.out.println(b);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
