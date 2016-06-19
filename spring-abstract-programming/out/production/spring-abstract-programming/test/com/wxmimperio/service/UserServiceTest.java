package com.wxmimperio.service;

import com.wxmimperio.dao.UserDAO;
import com.wxmimperio.model.User;
import com.wxmimperio.spring.BeanFactory;
import com.wxmimperio.spring.ClassPathXmlApplicationContext;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by wxmimperio on 2016/6/19.
 */
public class UserServiceTest {

    @Test
    public void add() throws Exception {
        //运行时候的上下文
        BeanFactory factory = new ClassPathXmlApplicationContext();

        //UserService的对象需要从配置文件中拿出来
        UserService service = new UserService();
        UserDAO userDAO = (UserDAO)factory.getBean("u");
        service.setUserDAO(userDAO);
        User u = new User();
        service.add(u);
    }
}