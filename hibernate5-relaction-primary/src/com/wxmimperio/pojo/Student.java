package com.wxmimperio.pojo;

/**
 * Created by wxmimperio on 2016/7/10.
 */
public class Student {
    private int id;
    private String name;
    private int age;
    private  StudentCard studentCard;

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

    public StudentCard getStudentCard() {
        return studentCard;
    }

    public void setStudentCard(StudentCard studentCard) {
        this.studentCard = studentCard;
    }
}
