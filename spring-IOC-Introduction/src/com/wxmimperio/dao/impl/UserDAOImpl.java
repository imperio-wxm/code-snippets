package com.wxmimperio.dao.impl;

import com.wxmimperio.dao.UserDAO;
import com.wxmimperio.model.User;

/**
 * Created by wxmimperio on 2016/6/19.
 * DAO层的实现
 */
public class UserDAOImpl implements UserDAO{

    private int daoId;
    private String daoStatus;

    public int getDaoId() {
        return daoId;
    }

    public void setDaoId(int daoId) {
        this.daoId = daoId;
    }

    public String getDaoStatus() {
        return daoStatus;
    }

    public void setDaoStatus(String daoStatus) {
        this.daoStatus = daoStatus;
    }

    @Override
    public void save(User user) {
        System.out.println("a usr save");
    }
}
