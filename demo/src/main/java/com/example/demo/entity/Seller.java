package com.example.demo.entity;

import jdk.nashorn.internal.objects.annotations.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 卖方
 */
@Entity
public class Seller {
    @Id
    private String id;          // 卖方Id
    private String name;        // 卖方姓名
    private String address;     // 卖方地址
    private String phoneNum;    // 卖方电话

    @Override
    public String toString() {
        return "Seller{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
}
