package com.wxmimperio.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Created by wxmimperio on 2016/6/24.
 */

@Aspect
//初始化
@Component
public class LogInterceptor {
    //在方法执行之前
    //织入点语法
    @Before("execution(public void com.wxmimperio.dao.impl.UserDAOImpl.save(com.wxmimperio.model.User))")
    public void before() {
        System.out.println("method start");
    }
}
