package com.model;

import java.io.Serializable;

/**
 * Created by wxmimperio on 2016/6/1.
 */

//对象要实现序列化接口
public class Computer implements Serializable {
    private String name;
    private float prize;
    private String color;

    //该字段不会被jvm默认序列化
    private transient String cpu;

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrize() {
        return prize;
    }

    public void setPrize(float prize) {
        this.prize = prize;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Computer() {
    }

    public Computer(String name, float prize, String color, String cpu) {
        this.name = name;
        this.prize = prize;
        this.color = color;
        this.cpu = cpu;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "name='" + name + '\'' +
                ", prize=" + prize +
                ", color='" + color + '\'' +
                ", cpu='" + cpu + '\'' +
                '}';
    }

    //手动进行序列化
    private void writeObject(java.io.ObjectOutputStream s) throws java.io.IOException {
        //把jvm能默认序列化的元素进行序列化操作
        s.defaultWriteObject();
        //自己完成手动序列化
        s.writeUTF(cpu);
    }

    private void readObject(java.io.ObjectInputStream s) throws java.io.IOException, ClassNotFoundException {
        //将jvm中默认反序列化的元素进行反序列化操作
        s.defaultReadObject();
        //自己完成反序列化的操作
        this.cpu = s.readUTF();
    }
}
