package com.objectopts;

/**
 * Created by wxmimperio on 2016/6/1.
 */

import com.model.Computer;
import com.utils.GetPath;

import java.io.*;

/**
 * 1. 对象序列化，就是将Object转换成byte序列，反序列化就是将byte序列转换成Object
 *
 * 2. 序列化流（ObjectOutputStream）——writeObject
 * 反序列化流（ObjectInputStream）——readObejct
 *
 * 3. 序列化接口（Serializable）
 * 对象必须实现序列化接口，才能进行序列化
 * 这个接口没有任何方法，只是一个标准
 *
 * 4. transient关键字可以使得字段不进行默认的序列化，可以自己完成序列化工作
 *
 * 5. 一个类实现了序列化接口，则子类也可以进行序列化
 *
 * 6. 对子类对象进行反序列化操作时：
 *      如果其父类没有实现序列化接口，那么其父类的构造函数会被调用
 */
public class ObjectSeria {
    public static void main(String[] args) {

        GetPath getPath = new GetPath();

        //得到父级目录
        String objPath = getPath.getCurrentPath() + "com/files/obj.dat";

        Computer computer = new Computer("联想", 5000, "黑色", "I7");

        //对象的序列化
        ObjectSeria objectSeria = new ObjectSeria();
        objectSeria.objSerialize(objPath, computer);

        //对象反序列化
        objectSeria.objDeserialize(objPath);
    }

    public void objSerialize(String fileName, Computer computer) {
        ObjectOutputStream oos = null;

        try {
            oos = new ObjectOutputStream(new FileOutputStream(fileName));
            //将一个对象的序列化写入文件
            oos.writeObject(computer);
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void objDeserialize(String fileName) {
        ObjectInputStream ois = null;

        try {
            ois = new ObjectInputStream(new FileInputStream(fileName));

            Computer computer = (Computer)ois.readObject();
            System.out.println(computer);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
