package com.wxmimperio.mybatis.dao.impl;

import com.wxmimperio.mybatis.dao.ConsumerDao;
import com.wxmimperio.mybatis.pojo.Consumer;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * Created by wxmimperio on 2016/9/25.
 */
public class ConsumerImpl implements ConsumerDao {

    private SqlSessionFactory sqlSessionFactory;

    //通过构造函数注入
    public ConsumerImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public Consumer findConsumerById(int id) throws Exception {
        //sqlSession线程不安全，要在方法体内声明
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Consumer consumer = sqlSession.selectOne("database.findUserById", id);
        sqlSession.close();
        return consumer;
    }

    @Override
    public boolean insertConsumer(Consumer consumer) throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.insert("database.insertConsumer", consumer);
        sqlSession.commit();
        sqlSession.close();
        return true;
    }

    @Override
    public boolean deleteConsumer(int id) throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.delete("database.deleteOrder", id);
        sqlSession.close();
        return true;
    }
}
