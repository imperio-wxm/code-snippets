package com.wxmimperio.pojo;

/**
 * Created by wxmimperio on 2016/7/10.
 */
public class Function {
    private int id;
    private String name;
    private String code;
    private String url;

    public Function() {
    }

    public Function(String name, String code, String url) {
        this.name = name;
        this.code = code;
        this.url = url;
    }

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
