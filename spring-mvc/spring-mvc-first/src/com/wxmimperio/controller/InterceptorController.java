package com.wxmimperio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by wxmimperio on 2016/8/14.
 */

@Controller
public class InterceptorController {

    @RequestMapping("interceptor")
    public String interceptor() {
        System.out.println("this is a interceptor controller");
        return "hello";
    }
}
