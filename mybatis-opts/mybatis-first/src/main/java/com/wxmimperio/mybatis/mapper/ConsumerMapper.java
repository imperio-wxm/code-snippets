package com.wxmimperio.mybatis.mapper;

import com.wxmimperio.mybatis.pojo.Consumer;

/**
 * Created by wxmimperio on 2016/9/25.
 */
public interface ConsumerMapper {

    //根据id查询用户信息
    Consumer findUserById(int id) throws Exception;

    //添加用户信息
    void insertConsumer(Consumer consumer) throws Exception;

    //删除用户信息
    void deleteOrder(int id) throws Exception;
}
