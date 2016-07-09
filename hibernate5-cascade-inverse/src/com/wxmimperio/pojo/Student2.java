package com.wxmimperio.pojo;

import java.sql.Blob;
import java.sql.Clob;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by wxmimperio on 2016/7/4.
 */
public class Student2 {
    private int id;
    private String name;
    private int age;

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
