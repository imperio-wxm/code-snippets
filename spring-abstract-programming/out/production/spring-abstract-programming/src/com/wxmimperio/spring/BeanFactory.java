package com.wxmimperio.spring;

/**
 * Created by wxmimperio on 2016/6/19.
 * bean的工厂接口
 */
public interface BeanFactory {
    public Object getBean(String name);
}
