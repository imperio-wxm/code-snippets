package com.wxmimperio.interceptor;


import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by wxmimperio on 2016/8/14.
 */
public class LoginInterceptor implements HandlerInterceptor {
    private List<String> allowedPass;

    //在请求方法处理之前执行
    //如果返回 true 则执行下一个拦截器， 如果返回false，则不执行下一个拦截器

    //需要处理那些url不被拦截，那些需要被拦截
    public boolean preHandle(HttpServletRequest httpServletRequest,
                             HttpServletResponse httpServletResponse, Object o) throws Exception {
        String url = httpServletRequest.getRequestURI();

        //先判断session中是否有
        Object user = httpServletRequest.getSession().getAttribute("user");
        if (user != null) {
            return true;
        }
        for (String temp : allowedPass) {
            if (url.endsWith(temp)) {
                return true;
            }
        }
        httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/jsp/login/login.jsp");
        return false;
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

    public List<String> getAllowedPass() {
        return allowedPass;
    }

    public void setAllowedPass(List<String> allowedPass) {
        this.allowedPass = allowedPass;
    }
}
