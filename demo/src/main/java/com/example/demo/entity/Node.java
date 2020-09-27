package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 节点
 */
@Entity
public class Node {

    @Id
    private String Id;          // 节点Id
    private String address;     // 节点地址

    @Override
    public String toString() {
        return "Node{" +
                "Id='" + Id + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
