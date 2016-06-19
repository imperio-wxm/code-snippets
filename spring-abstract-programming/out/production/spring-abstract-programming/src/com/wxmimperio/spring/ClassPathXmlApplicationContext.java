package com.wxmimperio.spring;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wxmimperio on 2016/6/19.
 */

public class ClassPathXmlApplicationContext implements BeanFactory {

    private Map<String, Object> beans = new HashMap<String, Object>();

    //构造方法
    public ClassPathXmlApplicationContext() throws Exception {
        SAXBuilder sb = new SAXBuilder();
        Document doc = sb.build(this.getClass().getClassLoader().getResourceAsStream("beans.xml"));
        Element root = doc.detachRootElement();//获取根元素
        List list = root.getChildren("bean");//获取名字为disk的所有元素
        for (int i = 0; i < list.size(); i++) {
            Element element = (Element) list.get(i);
            String id = element.getAttributeValue("id");
            String clazz = element.getAttributeValue("class");
            System.out.println(id + ":" + clazz);

            //利用反射生成class的对象
            Object o = Class.forName(clazz).newInstance();
            beans.put(id, o);
        }
    }

    @Override
    public Object getBean(String name) {
        //将来可以直接从Map容器中对象
        return beans.get(name);
    }
}
