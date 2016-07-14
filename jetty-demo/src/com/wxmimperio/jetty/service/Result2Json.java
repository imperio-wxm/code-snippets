package com.wxmimperio.jetty.service;

import net.sf.json.JSONObject;

/**
 * Created by weiximing.imperio on 2016/7/14.
 */
public interface Result2Json {
    JSONObject result2Json(String id, String username, String age, String gender);
}
