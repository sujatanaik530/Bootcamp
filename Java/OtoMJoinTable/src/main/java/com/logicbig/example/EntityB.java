package com.logicbig.example;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class EntityB {
    @Id
    @GeneratedValue
    private int myIdB;
    private String str;

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    @Override
    public String toString() {
        return "EntityB{" +
                "myIdB=" + myIdB +
                ", str='" + str + '\'' +
                '}';
    }
}