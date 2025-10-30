package com.example.AUg5_SpringProject.designPattern.creational.builder;

public class User {
    private int id;
    private String name;
    private String address;

    private User(Builder builder){
        this.address=builder.address;
        this.name=builder.name;
        this.id= builder.id;
    }

    public static class Builder{
        private  int id;
        private String name;
        private String address;
        public Builder setId(int id){
            this.id=id;
            return this;
        }
        public Builder setName(String name){
            this.name=name;
            return this;
        }

        public  Builder setAddress(String address){
            this.address=address;
            return this;
        }

        public User build(){
            return new User(this);
        }

        public String toString(){
            return "Id="+id+"\nname="+name+"\naddress="+address;
        }
    }
}
