package com.example.demo1.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ayuser")
public class AyUser {
    @Id
    private String id; //primary key
    private String type;
    private int age;
    private String password;

    public void setId(String id){
        this.id = id;
    }
    public void setType(String type){
        this.type = type;
    }
    public void setAge(int age){
        this.age = age;
    }
    public void setPassword(String s){
        this.password = s;
    }

    @javax.persistence.Id
    public String getId(){
        return this.id;
    }
    public int getAge(){
        return this.age;
    }
    public String getType(){
        return this.type;
    }
    public String getPassword(){
        return this.password;
    }

    @Override
    public String toString(){
        return " id : " + id + " , type : " + type;
    }


}
