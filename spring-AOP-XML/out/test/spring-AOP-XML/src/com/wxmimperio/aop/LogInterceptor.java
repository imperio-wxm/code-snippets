package com.wxmimperio.aop;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created by wxmimperio on 2016/6/25.
 */


public class LogInterceptor {
    public void before() {
        System.out.println("method before");
    }

    public void after() {
        System.out.println("method after");
    }

    public void afterReturn() {
        System.out.println("method after returning");
    }

    public void beforeMethod() {
        System.out.println("this is before method");
    }
}
