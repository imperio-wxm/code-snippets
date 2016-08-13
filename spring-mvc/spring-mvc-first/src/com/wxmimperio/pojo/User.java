package com.wxmimperio.pojo;

/**
 * Created by wxmimperio on 2016/8/11.
 */
public class User {

    private String name;
    private int age;
    private String gender;

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "name=" + getName() + ",age=" + getAge() + ",gender=" + getGender();
    }
}
