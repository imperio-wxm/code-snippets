package com.wxmimperio.pojo;

/**
 * Created by wxmimperio on 2016/7/10.
 */
public class StudentCard {
    private int id;
    private String code;
    private Student student;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
