package com.wxmimperio.mybatis.first;

import com.wxmimperio.mybatis.pojo.Consumer;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

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

    public static List<Consumer> findByName() {
        List<Consumer> consumers = new ArrayList<Consumer>();

        String xml = "mybatis-config.xml";

        //1.创建会话工厂，传入mybatis的配置信息
        InputStream inputStream = null;
        SqlSession sqlSession = null;
        try {
            inputStream = Resources.getResourceAsStream(xml);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            //2.得到sqlsession
            sqlSession = sqlSessionFactory.openSession();

            consumers = sqlSession.selectList("database.findUserByName", "1");
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
        return consumers;
    }

    public static boolean insertInto() {
        String xml = "mybatis-config.xml";

        //1.创建会话工厂，传入mybatis的配置信息
        InputStream inputStream = null;
        SqlSession sqlSession = null;

        Consumer consumer = new Consumer();
        try {
            inputStream = Resources.getResourceAsStream(xml);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            //2.得到sqlsession
            sqlSession = sqlSessionFactory.openSession();
            consumer.setUsername("insert user1");
            consumer.setPassword(".......");

            sqlSession.insert("database.insertConsumer", consumer);

            //手动提交
            sqlSession.commit();

            System.out.println("插入之后取得id=" + consumer.getId());
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
        return true;
    }

    public static boolean deleteById() {
        String xml = "mybatis-config.xml";

        //1.创建会话工厂，传入mybatis的配置信息
        InputStream inputStream = null;
        SqlSession sqlSession = null;

        try {
            inputStream = Resources.getResourceAsStream(xml);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            //2.得到sqlsession
            sqlSession = sqlSessionFactory.openSession();
            sqlSession.delete("database.deleteOrder", 1);

            //手动提交
            sqlSession.commit();
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
        return true;
    }

    public static boolean updateInto() {
        String xml = "mybatis-config.xml";

        //1.创建会话工厂，传入mybatis的配置信息
        InputStream inputStream = null;
        SqlSession sqlSession = null;

        Consumer consumer = new Consumer();
        try {
            inputStream = Resources.getResourceAsStream(xml);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            //2.得到sqlsession
            sqlSession = sqlSessionFactory.openSession();
            consumer.setId(1);
            consumer.setUsername("update consumer");
            consumer.setPassword("update password");

            sqlSession.insert("database.updateConsumer", consumer);

            //手动提交
            sqlSession.commit();
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
        return true;
    }
}
