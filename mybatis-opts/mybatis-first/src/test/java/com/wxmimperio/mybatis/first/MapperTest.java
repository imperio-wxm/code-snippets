package com.wxmimperio.mybatis.first;

import com.wxmimperio.mybatis.mapper.ConsumerMapper;
import com.wxmimperio.mybatis.pojo.Consumer;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

/**
 * Created by wxmimperio on 2016/9/25.
 */
public class MapperTest {
    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void setUp() throws Exception {
        String xml = "mybatis-config.xml";
        //1.创建会话工厂，传入mybatis的配置信息
        InputStream inputStream = Resources.getResourceAsStream(xml);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void mapperTest() throws Exception{
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //通过mapper反射获取map per对象
        ConsumerMapper consumerMapper = sqlSession.getMapper(ConsumerMapper.class);
        Consumer consumer = consumerMapper.findUserById(1);
        System.out.println(consumer.getId() + " " + consumer.getUsername() + " " + consumer.getPassword());

        Consumer consumer1 = new Consumer();
        consumer1.setPassword("123456abc");
        consumer1.setUsername("mapper insert consumer");
        consumerMapper.insertConsumer(consumer1);
        sqlSession.commit();
        sqlSession.close();

    }
}
