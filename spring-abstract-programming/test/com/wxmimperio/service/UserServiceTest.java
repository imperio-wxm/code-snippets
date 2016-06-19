package com.wxmimperio.service;

import com.wxmimperio.model.User;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by wxmimperio on 2016/6/19.
 */
public class UserServiceTest {

    @Test
    public void add() throws Exception {
        UserService userService = new UserService();
        User user = new User();
        userService.add(user);
    }
}