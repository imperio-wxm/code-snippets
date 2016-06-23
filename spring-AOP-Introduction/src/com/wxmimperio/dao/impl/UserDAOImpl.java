package com.wxmimperio.dao.impl;

import com.wxmimperio.dao.UserDAO;
import com.wxmimperio.model.User;

/**
 * Created by wxmimperio on 2016/6/19.
 * DAO层的实现
 */
public class UserDAOImpl implements UserDAO{
    @Override
    public void save(User user) {
        System.out.println("a usr save");
    }

    @Override
    public void delete(User user) {
        System.out.println("delete user");
    }
}
