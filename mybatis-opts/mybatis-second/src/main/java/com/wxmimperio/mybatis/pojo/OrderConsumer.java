package com.wxmimperio.mybatis.pojo;

/**
 * Created by wxmimperio on 2016/10/7.
 */
public class OrderConsumer extends Order{
    private String userName;
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
