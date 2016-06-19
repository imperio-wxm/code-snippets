package com.wxmimperio.service;

import com.wxmimperio.dao.UserDAO;
import com.wxmimperio.model.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * Created by wxmimperio on 2016/6/19.
 */
public class UserServiceTest {

    @Test
    public void add() throws Exception {
        //运行时候的上下文
        //ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");

        //UserService的对象需要从配置文件中拿出来
        UserService service = (UserService)ctx.getBean("userService");

        User u = new User();
        service.add(u);

        UserDAO userDAO = (UserDAO)ctx.getBean("userDAO");
        System.out.println(userDAO);

        ctx.destroy();
    }
}