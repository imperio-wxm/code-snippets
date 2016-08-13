package com.wxmimperio.controller;


import com.wxmimperio.pojo.User;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;

import java.io.IOException;

/**
 * Created by wxmimperio on 2016/8/6.
 */

@Controller
public class HelloController {
    /**
     * 方式一：通过ModelAndView跳转结果
     */
    /*@RequestMapping("/test/test")
    public ModelAndView hello(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView mv = new ModelAndView();
        //封装要显示到视图的数据
        mv.addObject("msg","hello spring mvc");
        //设置视图名称
        mv.setViewName("hello");
        System.out.println("test");
        return mv;
    }*/

    /**
     * 方式二：通过httpservlet api直接输出
     * 不需要视图解析器配置xml
     * 也可以进行重定向（httpServletResponse）
     */
    /*@RequestMapping("hello")
    public void hello(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        try {
            httpServletResponse.getWriter().write("this is httpservlet api");
            //重定向
            //httpServletResponse.sendRedirect("");

            //请求转发
            //httpServletRequest.setAttribute("msg", "this is set Attribute");
            *//*try {
                httpServletRequest.getRequestDispatcher("index.jsp").forward(httpServletRequest, httpServletResponse);
            } catch (ServletException e) {
                e.printStackTrace();
            }*//*
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

    /**
     * 方式三：spring mvc 重定向和转发(没有视图解析器)
     */
    /*@RequestMapping("hello")
    public String hello() {
        //转发1，地址栏不变
        //return "index.jsp";
        //转发2，前缀
        //return "forword:index.jsp";

        //重定向
        return "redirect:index.jsp";
    }*/

    /**
     *  方式四：spring mvc 重定向和转发(有视图解析器)
     */
    /*@RequestMapping("hello")
    public String hello() {
        //转发
        return "index";

        //重定向不需要视图解析器
        //return "redirect:index.jsp";
    }*/


    /**
     * 处理数据
     * (域名称和数据名可以不一样)
     * <p>
     * 返回数据——ModelMap
     */
    @RequestMapping("hello")
    public String hello(@RequestParam("username") String name, ModelMap modelMap) {
        modelMap.addAttribute("username", name);
        System.out.println(name);
        return "index";
    }

    /**
     * 处理对象
     */
    @RequestMapping("user")
    public String user(User user) {
        System.out.println(user);
        return "index";
    }

    /**
     * Festful风格
     *
     * @PathVariable 去修饰，表示路径变量
     */
    @RequestMapping("{uid}/restful/{id}")
    public String restful(@PathVariable String id, @PathVariable String uid) {
        System.out.println(id);
        System.out.println(uid);
        return "index";
    }
}
