package com.fileopts;

import com.utils.GetPath;
import com.utils.IOUtils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

/**
 * Created by wxmimperio on 2016/6/1.
 */
public class BufferedWriterReader {
    public static void main(String[] args) {

        int c;
        char[] buffer = new char[10 * 1024];
        GetPath getPath = new GetPath();
        String readlines;

        //得到父级目录
        String oldFilePath = getPath.getCurrentPath() + "com/files/file_test.txt";
        String newFilePath = getPath.getCurrentPath() + "com/files/bw_br_test.txt";

        BufferedWriter bw = IOUtils.BufferedWriterOpt(newFilePath);
        BufferedReader br = IOUtils.BufferedReaderOpt(oldFilePath);

        try {
            /*直接写字符数组
            while ((c = br.read(buffer, 0, buffer.length)) != -1) {
                bw.write(buffer, 0, c);
                bw.flush();
            }*/
            while ((readlines = br.readLine()) !=  null) {
                //一次读取一行，但是不能识别换行\n
                System.out.println(readlines);
                //直接写一行
                bw.write(readlines);
                //写出换行操作
                bw.newLine();
                bw.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.BufferedReaderClose(br);
            IOUtils.BufferedWriterClose(bw);
        }
    }
}
