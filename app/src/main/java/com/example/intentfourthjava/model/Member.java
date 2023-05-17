package com.example.intentfourthjava.model;

import java.io.Serializable;

public class Member implements Serializable {
    private int age;
    private String name;

    public Member(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Member{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

