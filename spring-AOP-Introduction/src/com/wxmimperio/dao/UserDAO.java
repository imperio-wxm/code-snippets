package com.wxmimperio.dao;

import com.wxmimperio.model.User;

/**
 * Created by wxmimperio on 2016/6/19.
 * 数据库访问层接口
 */

public interface UserDAO {
    public void save (User user);
    public void delete (User user);
}
