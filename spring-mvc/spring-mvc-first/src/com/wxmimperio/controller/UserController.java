package com.wxmimperio.controller;

import com.wxmimperio.pojo.LoginUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by wxmimperio on 2016/8/14.
 */
@Controller
public class UserController {

    @RequestMapping("login")
    public String login(LoginUser loginUser, HttpSession httpSession) {
        if ("wxmimperio".equals(loginUser.getName()) &&
                "123456".equals(loginUser.getPassword())) {
            httpSession.setAttribute("user", loginUser);
            System.out.println("成功");
            return "redirect:/jsp/hello.jsp";
        }
        return "redirect:/jsp/login/login.jsp";
    }

    @RequestMapping("add")
    public String add() {
        System.out.println("add.do");
        return "redirect:/jsp/login/login.jsp";
    }
}
