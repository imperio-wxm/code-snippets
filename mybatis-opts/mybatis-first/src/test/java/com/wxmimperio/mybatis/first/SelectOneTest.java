package com.wxmimperio.mybatis.first;

import com.wxmimperio.mybatis.pojo.Consumer;
import org.junit.Test;

import java.util.List;

/**
 * Created by wxmimperio on 2016/9/18.
 */
public class SelectOneTest {

    @Test
    public void selectByIdTest() {
        SelectOne.selectById();
    }

    @Test
    public void selectByNameTest() {
        List<Consumer> consumers = SelectOne.findByName();
        for (Consumer consumer : consumers) {
            System.out.println("id=" + consumer.getId() + " username=" + consumer.getUsername() + " password=" + consumer.getPassword());
        }
    }
}
