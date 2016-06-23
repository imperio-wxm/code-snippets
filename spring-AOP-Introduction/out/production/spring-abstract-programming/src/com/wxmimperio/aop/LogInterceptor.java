package com.wxmimperio.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by wxmimperio on 2016/6/23.
 */
public class LogInterceptor implements InvocationHandler{
    private Object target;

    public void beforeMethod() {
        System.out.println("save start");
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //调用任何方法之前都调用此方法
        beforeMethod();
        //被调函数
        method.invoke(target,args);
        return null;
    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }
}
