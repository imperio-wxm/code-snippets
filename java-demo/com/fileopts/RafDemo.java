package com.fileopts;

/**
 * Created by wxmimperio on 2016/5/31.
 */

import com.utils.GetPath;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

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

        //System.out.println(file_path);

        RandomAccessFile raf = null;

        try {
            raf = new RandomAccessFile(new File(file_path), "rwd");

            //获取文件指针
            System.out.println(raf.getFilePointer());

            //写入，只写一个字节
            //raf.write('A');

            //raf.writeUTF("raf的writeChars方法");

            //将文件指针移到头部
            raf.seek(0);

            //一次性将文件中的内容读取，全部读到字节数组中
            byte[] bytes = new byte[(int) raf.length()];
            raf.read(bytes);
            System.out.println(Arrays.toString(bytes));

            //转成string
            String string = new String(bytes, "utf-8");
            System.out.println(string);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(raf != null) {
                try {
                    raf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
