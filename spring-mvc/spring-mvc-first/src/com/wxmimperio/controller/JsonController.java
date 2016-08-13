package com.wxmimperio.controller;

import com.wxmimperio.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wxmimperio on 2016/8/13.
 */
@Controller
public class JsonController {

    @RequestMapping("jsp/json")
    @ResponseBody
    public List<User> json() {
        List<User> list = new ArrayList<User>();
        list.add(new User("wxmimperio",20,"男"));
        list.add(new User("1",21,"男"));
        list.add(new User("2",22,"男"));
        list.add(new User("3",23,"男"));
        return list;
    }
}
