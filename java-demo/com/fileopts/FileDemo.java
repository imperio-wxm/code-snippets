package com.fileopts;
import com.utils.GetPath;

import java.io.File;

/**
 * Created by wxmimperio on 2016/5/31.
 */
public class FileDemo {
    public static void main(String[] args) {
        GetPath getPath = new GetPath();
        //得到父级目录
        String file_path = getPath.getCurrentPath() + "files/file_test.txt";

        System.out.println(file_path);

        //了解构造函数的情况
        File file = new File(file_path);
        //判断文件是否存在
        System.out.println("文件是否存在：" + file.exists());

        //创建和删除目录
        /*
        if (!file.exists()) {
            file.mkdir();
            //多级目录
            file.mkdirs();
        } else {
            file.delete();
        }*/

        //判断是否是一个目录，不是目录或者目录不存在，返回false
        System.out.println("是否是一个目录：" + file.isDirectory());

        //判断是否是一个文件
        System.out.println("是否是一个文件：" + file.isFile());

        //File常用API

        //直接打印file，调用的是toString，打印路径
        System.out.println(file);

        //获得绝对路径
        System.out.println(file.getAbsolutePath());

        //获取文件名，如果是，目录，则打印，目录名
        System.out.println("文件名是：" + file.getName());

        //得到父目录路径
        System.out.println("父目录路径：" + file.getParent());
    }
}
