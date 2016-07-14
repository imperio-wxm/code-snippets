package com.wxmimperio.jetty.serviceimpl;

import com.wxmimperio.jetty.pojo.User;
import com.wxmimperio.jetty.service.Result2Json;
import net.sf.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by weiximing.imperio on 2016/7/14.
 */
public class Result2JsonImpl implements Result2Json{

    @Override
    public JSONObject result2Json(String id, String username, String age, String gender) {
        Map<String,String > map = new HashMap<String, String>();
        map.put("username",username + "已经经过处理");
        map.put("id",id + "已经经过处理");
        map.put("age",age + "已经经过处理");
        map.put("gender",gender + "已经经过处理");

        JSONObject jsonObject = JSONObject.fromObject(map);

        //下面可以做dao层的操作

        User user = new User();
        user.setId(id);
        user.setUsername(username);
        user.setAge(age);
        user.setGender(gender);

        return jsonObject;
    }
}
