package com.wxmimperio.mybatis.mapper;


import com.wxmimperio.mybatis.pojo.OrderConsumer;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * Created by wxmimperio on 2016/10/7.
 */
public class OrderConsumerTest {
    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void setUp() throws Exception {
        String xml = "mybatis-config.xml";
        //1.创建会话工厂，传入mybatis的配置信息
        InputStream inputStream = Resources.getResourceAsStream(xml);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void testFindOrderConsumer() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrderConsumerMapper orderConsumerMapper = sqlSession.getMapper(OrderConsumerMapper.class);

        List<OrderConsumer> orderConsumers = orderConsumerMapper.findOrdersConsumer();
        for (OrderConsumer orderConsumer : orderConsumers) {
            System.out.println(orderConsumer.getId() + " " + orderConsumer.getPassword() + " "
                    + orderConsumer.getUserName() + " " + orderConsumer.getGoodsId() + " " +
                    orderConsumer.getConsumerId());
        }
    }
}
