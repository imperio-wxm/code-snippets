package com.wxmimperio.mybatis.first;

import com.wxmimperio.mybatis.dao.ConsumerDao;
import com.wxmimperio.mybatis.dao.impl.ConsumerImpl;
import com.wxmimperio.mybatis.pojo.Consumer;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

/**
 * Created by wxmimperio on 2016/9/25.
 */
public class DaoTest {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void setUp() throws Exception {
        String xml = "mybatis-config.xml";
        //1.创建会话工厂，传入mybatis的配置信息
        InputStream inputStream = Resources.getResourceAsStream(xml);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void daoTest() throws Exception {
        ConsumerDao consumerDao = new ConsumerImpl(sqlSessionFactory);

        Consumer consumer = consumerDao.findConsumerById(1);
        System.out.println(consumer.getId() + " " + consumer.getUsername() + " " + consumer.getPassword());
    }
}
