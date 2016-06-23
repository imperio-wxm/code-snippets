package com.wxmimperio.service;

import com.wxmimperio.aop.LogInterceptor;
import com.wxmimperio.dao.UserDAO;
import com.wxmimperio.dao.impl.UserDAOImpl;
import com.wxmimperio.model.User;
import com.wxmimperio.spring.BeanFactory;
import com.wxmimperio.spring.ClassPathXmlApplicationContext;
import org.junit.Test;

import java.lang.reflect.Proxy;

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
        UserService service = (UserService)factory.getBean("userService");
        User u = new User();
        service.add(u);
    }

    //java动态代理模拟spring AOP机制
    @Test
    public void testProxy() {
        //产生被代理对象
        UserDAO userDAO = new UserDAOImpl();
        //设置被代理对象
        LogInterceptor logInterceptor = new LogInterceptor();
        logInterceptor.setTarget(userDAO);

        /**
         * param1：被代理对象的classLoader()
         * param2：被代理对象所实现的接口
         * param2：用哪个handler处理
         * 由于实现了UserDao的接口，所以可以强制转换
         */
        UserDAO userDAOProxy = (UserDAO)Proxy.newProxyInstance(userDAO.getClass().getClassLoader(),
                new Class[]{UserDAO.class},logInterceptor);
        //可以给任何方法加
        userDAOProxy.save(new User());
        userDAOProxy.delete(new User());
    }
}