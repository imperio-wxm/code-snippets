package com.wxmimperio.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by wxmimperio on 2016/7/4.
 */
public class Subject {
    private int id;
    private String name;
    private Set<Student2> student2s = new HashSet<Student2>();

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

    public Set<Student2> getStudent2s() {
        return student2s;
    }

    public void setStudent2s(Set<Student2> student2s) {
        this.student2s = student2s;
    }
}
