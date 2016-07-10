package com.wxmimperio.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by wxmimperio on 2016/7/10.
 */
public class Role {
    private int id;
    private String name;
    private Set<Function> functions = new HashSet<Function>();

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

    public Set<Function> getFunctions() {
        return functions;
    }

    public void setFunctions(Set<Function> functions) {
        this.functions = functions;
    }
}
