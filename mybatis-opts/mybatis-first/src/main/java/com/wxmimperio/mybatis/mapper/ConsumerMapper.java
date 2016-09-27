package com.wxmimperio.mybatis.mapper;

import com.wxmimperio.mybatis.pojo.Consumer;
import com.wxmimperio.mybatis.pojo.ConsumerExtend;
import com.wxmimperio.mybatis.pojo.ConsumerQueryVo;

import java.util.List;

/**
 * Created by wxmimperio on 2016/9/25.
 */
public interface ConsumerMapper {

    //信息综合查询
    List<ConsumerExtend> findConsumerList(ConsumerQueryVo consumerQueryVo) throws Exception;

    //综合信息总数
    int findConsumerCount(ConsumerQueryVo consumerQueryVo) throws Exception;

    //根据id查询用户信息
    Consumer findUserById(int id) throws Exception;

    //添加用户信息
    void insertConsumer(Consumer consumer) throws Exception;

    //删除用户信息
    void deleteOrder(int id) throws Exception;
}
