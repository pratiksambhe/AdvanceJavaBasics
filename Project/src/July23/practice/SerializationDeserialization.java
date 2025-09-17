package July23.practice;

import java.io.*;

public class SerializationDeserialization implements Serializable {
    int id;
    String name;
    public SerializationDeserialization(int id,String name){
        this.id=id;
        this.name=name;

    }
    @Override
    public String toString(){
        return "SerializationDeserialization {"+"\nid: "+id+"\n name: "+name+"\n}";
    }

    public static void main(String[] args) {
        SerializationDeserialization s=new SerializationDeserialization(1,"Pratik");
        try{
            ObjectOutputStream ob=new ObjectOutputStream(new FileOutputStream("C:\\Users\\Sreenivas Bandaru\\Desktop\\java\\mynew.ser"));
            ob.writeObject(s);

     ob.close();
        }catch( IOException  e){
        System.out.println(e);
    };

    try{
        ObjectInputStream ob2=new ObjectInputStream(new FileInputStream("C:\\Users\\Sreenivas Bandaru\\Desktop\\java\\mynew.ser"));
        Object s2=ob2.readObject();
        System.out.println(s2);
        ob2.close();
    }catch (NullPointerException | ClassNotFoundException | IOException e){
        System.out.println(e);
    }
    }
}
