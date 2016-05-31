package com.utils;

import java.io.File;
import java.io.IOException;

/**
 * Created by wxmimperio on 2016/5/31.
 */
public class FileUtils {
    /**
     * 列出指定目录下（包括子目录）的所有文件
     * @param dir
     * @throws IOException
     */
    public static void listDirectory(File dir) throws IOException {
        if (!dir.exists()) {
            throw new IllegalArgumentException("目录：" + dir + "不存在");
        } else if (!dir.isDirectory()) {
            throw new IllegalArgumentException(dir + "不是目录");
        } else {
            //返回的是文件的名称，字符串数组，不含子目录
            /*String[] filesname = dir.list();
            for(String filename: filesname) {
                System.out.print(filename + " ");
            }*/

            //如果要遍历子目录下的内容，就要生成File对象，做递归操作
            File[] file_list = dir.listFiles();
            if (file_list != null && file_list.length > 0) {
                for(File file : file_list) {
                    if (file.isDirectory()) {
                        listDirectory(file);
                    } else {
                        System.out.println(file);
                    }
                }
            }
        }
    }
}
