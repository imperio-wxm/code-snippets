package com.wxmimperio.mybatis.mapper;

import com.wxmimperio.mybatis.pojo.OrderConsumer;

import java.util.List;

/**
 * Created by wxmimperio on 2016/10/7.
 */
public interface OrderConsumerMapper {
    //关联订单和用户
    public List<OrderConsumer> findOrdersConsumer() throws Exception;
}
