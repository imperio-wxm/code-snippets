package com.wxmimperio.interceptor;


import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by wxmimperio on 2016/8/14.
 */
public class MyInterceptor implements HandlerInterceptor {
    //在请求方法处理之前执行
    //如果返回 true 则执行下一个拦截器， 如果返回false，则不执行下一个拦截器
    public boolean preHandle(HttpServletRequest httpServletRequest,
                             HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("处理前");
        return true;
    }

    //在请求方法处理之后执行
    public void postHandle(HttpServletRequest httpServletRequest,
                           HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("处理后");
    }

    //在DispatcherServlet（适配器）处理之后执行——清理工作
    public void afterCompletion(HttpServletRequest httpServletRequest,
                                HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
