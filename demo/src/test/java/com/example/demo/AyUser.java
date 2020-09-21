package com.example.demo;

import org.springframework.data.annotation.Id;

import javax.persistence.Entity;

@Entity
public class AyUser {
    @Id
    private String id; //primary key
    private String name;
    private int age;
    private String address;

    public void setId(String id){
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setAge(int age){
        this.age = age;
    }
    public void setAddress(String s){
        this.address = s;
    }

    @javax.persistence.Id
    public String getId(){
        return this.id;
    }
    public int getAge(){
        return this.age;
    }
    public String getName(){
        return this.name;
    }
    public String getAddress(){
        return this.address;
    }

    @Override
    public String toString(){
        return " id : " + id + " , name : " + name + " , age : " + age + " , address : " + address;
    }


}
