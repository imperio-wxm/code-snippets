package com.wxmimperio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by wxmimperio on 2016/8/13.
 *
 * HttpServletResponse 处理ajax请求
 */
@Controller
public class AjaxController {

    @RequestMapping("jsp/ajax")
    public void ajaxController(String name, HttpServletResponse response) throws IOException {
        if ("wxmimperio".equals(name)) {
            response.getWriter().print("true");
        } else {
            response.getWriter().print("false");
        }
    }
}
