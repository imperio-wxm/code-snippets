package com.wxmimperio.mybatis.first;

import com.wxmimperio.mybatis.pojo.Consumer;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by wxmimperio on 2016/9/17.
 */
public class SelectOne {
    public static Consumer selectById() {
        Consumer consumer = null;
        String xml = "mybatis-config.xml";

        //1.创建会话工厂，传入mybatis的配置信息
        InputStream inputStream = null;
        SqlSession sqlSession = null;
        try {
            inputStream = Resources.getResourceAsStream(xml);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            //2.得到sqlsession
            sqlSession = sqlSessionFactory.openSession();

            //3.操作数据库
            /*
                第一个参数：映射文件中statement的id，等于=namespace.statementId*/
            consumer = sqlSession.selectOne("database.findUserById", 1);
            System.out.println("id=" + consumer.getId() + " username=" + consumer.getUsername() + " password=" + consumer.getPassword());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert inputStream != null;
                inputStream.close();
                assert sqlSession != null;
                sqlSession.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return consumer;
    }
}
