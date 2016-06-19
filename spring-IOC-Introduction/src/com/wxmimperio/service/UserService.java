package com.wxmimperio.service;

import com.wxmimperio.dao.UserDAO;
import com.wxmimperio.dao.impl.UserDAOImpl;
import com.wxmimperio.model.User;

/**
 * Created by wxmimperio on 2016/6/19.
 * 业务逻辑层
 */
public class UserService {
    //保存一个UserDAO的引用，用来操作数据
    //面向接口编程
    /*
    public UserService(UserDAO userDAO) {
        super();
        this.userDAO = userDAO;
    }*/

    /**
     * 面向接口编程的灵活性
     * 可以根据不同的Impl实现来采用不同的dao层实现方式
     */

    private UserDAO userDAO;

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    //添加用户
    public void add (User user) {
        this.userDAO.save(user);
    }

    public void init() {
        System.out.println("This is init");
    }

    public void destroy() {
        System.out.println("This is destroy");
    }
}
