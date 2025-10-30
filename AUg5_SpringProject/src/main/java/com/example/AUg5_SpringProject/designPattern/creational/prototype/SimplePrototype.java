package com.example.AUg5_SpringProject.designPattern.creational.prototype;

public class SimplePrototype implements Cloneable {

    private int id;
    private String name;
    public SimplePrototype(){

    }
    public SimplePrototype(int id, String name){
    this.id=id;
    this.name=name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static SimplePrototype getInstance(){
        return new SimplePrototype();
    }
    public SimplePrototype clone() throws CloneNotSupportedException {
        return (SimplePrototype) super.clone();
    }

    @Override
    public String toString() {
        return "SimplePrototype{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public static void main(String[]args) throws CloneNotSupportedException {
        SimplePrototype s=new SimplePrototype(1,"Pratik");
        SimplePrototype clone = s.clone();
        clone.setId(2);
        clone.setName("Om");

        System.out.println(clone==s);
    }
}
