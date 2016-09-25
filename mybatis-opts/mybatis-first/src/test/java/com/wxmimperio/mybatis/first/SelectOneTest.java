package com.wxmimperio.mybatis.first;

import com.wxmimperio.mybatis.pojo.Consumer;
import org.junit.Test;

import java.util.List;
import java.util.UUID;

/**
 * Created by wxmimperio on 2016/9/18.
 */
public class SelectOneTest {

    @Test
    public void selectByIdTest() {
        SelectOne.selectById();
        /*UUID的生成
        System.out.println(UUID.randomUUID().toString());*/
    }

    @Test
    public void selectByNameTest() {
        List<Consumer> consumers = SelectOne.findByName();
        for (Consumer consumer : consumers) {
            System.out.println("id=" + consumer.getId() + " username=" + consumer.getUsername() + " password=" + consumer.getPassword());
        }
    }

    @Test
    public void insertIntoTest() {
        boolean flag = SelectOne.insertInto();
        System.out.println(flag);
    }

    @Test
    public void deleteByIdTest() {
        boolean flag = SelectOne.deleteById();
        System.out.println(flag);
    }

    @Test
    public void updateTest() {
        boolean flag = SelectOne.updateInto();
        System.out.println(flag);
    }
}
