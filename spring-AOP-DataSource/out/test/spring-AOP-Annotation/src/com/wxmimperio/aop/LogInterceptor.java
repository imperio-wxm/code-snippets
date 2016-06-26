package com.wxmimperio.aop;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created by wxmimperio on 2016/6/25.
 */

//声明这是切面逻辑
@Aspect
//对代理进行初始化
@Component
public class LogInterceptor {
    //在方法执行之前
    //织入点语法

    /**
     * 表示：
     *  1.返回值是任何类型
     *  2.com.wxmimperio.dao..（com.wxmimperio.dao下所有子包的所有类）
     *  3..*(..)（所有方法）
     */
    @Before("execution(public * com.wxmimperio.dao..*.*(..))")
    //@Before("execution(public void com.wxmimperio.dao.impl.UserDAOImpl.save(com.wxmimperio.model.User))")
    public void before() {
        System.out.println("method before");
    }

    @After("execution(public void com.wxmimperio.dao.impl.UserDAOImpl.save(com.wxmimperio.model.User))")
    public void after() {
        System.out.println("method after");
    }

    /**
     * 方法正常返回之后
     */
    @AfterReturning("execution(public * com.wxmimperio.dao..*.*(..))")
    public void afterReturn() {
        System.out.println("method after returning");
    }

    /**
     * 抽象提出织入点语法
     *  如果有相同的织入点语法，可以提出来
     */
    @Pointcut("execution(public * com.wxmimperio.dao..*.*(..))")
    public void method() {}

    @Before("method()")
    public void beforeMethod() {
        System.out.println("this is before method");
    }
}
