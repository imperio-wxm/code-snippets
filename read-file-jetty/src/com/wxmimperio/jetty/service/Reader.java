package com.wxmimperio.jetty.service;

import com.wxmimperio.jetty.pojo.Page;

/**
 * Created by weiximing.imperio on 2016/7/14.
 */
public interface Reader {
    Page read(String id, String startLine, String endLine);
}
