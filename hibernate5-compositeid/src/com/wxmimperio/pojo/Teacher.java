package com.wxmimperio.pojo;

/**
 * Created by wxmimperio on 2016/7/4.
 */
public class Teacher {
    private int id;
    private String name;
    private String sex;
    //组件的存储
    private Adderss adderss;

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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Adderss getAdderss() {
        return adderss;
    }

    public void setAdderss(Adderss adderss) {
        this.adderss = adderss;
    }
}
