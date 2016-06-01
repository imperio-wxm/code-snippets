package com.fileopts;

/**
 * Created by wxmimperio on 2016/5/31.
 */

import com.utils.GetPath;

import java.io.File;

/**
 * RandomAccessFile
 * java 提供的文件内容的访问，支持读/写
 * 支持随机访问，可以访问文件任意位置
 *
 * （1）java文件模型
 *      在硬盘删个文件是byte存储的数据集合
 * （2）打开文件
 *      有两种模式"rw"读写，"r"只读
 *      RandomAccessFile raf = new RandomAccessFile(file, "rw");
 *      文件指针，打开文件时指针在开头 pointer = 0;
 * （3）写方法
 *      raf.write(int)-------> 只写一个字节（后8位），同时指针指向下一个位置，准备再次写入
 * （4）读方法
 *      int b = raf.read()-------> 读一个字节
 * （5）关闭流
 *      文件读写完成后一定关闭
 */
public class RafDemo {
    public static void main(String[] args) {
        GetPath getPath = new GetPath();
        //得到父级目录
        String file_path = getPath.getCurrentPath() + "com/files/file_test.txt";

        System.out.println(file_path);

        File file = new File(file_path);
        System.out.println(file.exists());
    }
}
