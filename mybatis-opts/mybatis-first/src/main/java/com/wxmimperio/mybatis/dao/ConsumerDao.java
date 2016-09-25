package com.wxmimperio.mybatis.dao;

import com.wxmimperio.mybatis.pojo.Consumer;

/**
 * Created by wxmimperio on 2016/9/25.
 */
public interface ConsumerDao {
    //根据id查询用户信息
    Consumer findConsumerById(int id) throws Exception;

    //添加用户信息
    boolean insertConsumer(Consumer consumer) throws Exception;

    //删除用户信息
    boolean deleteConsumer(int id) throws Exception;


}
