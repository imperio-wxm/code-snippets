package com.utils;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by wxmimperio on 2016/6/1.
 * 读取指定文件内容，每输出10个bytes，换行
 */
public class IOUtils {
    /**
     * FileInputStream文件输入流
     * 单字节读取（读取较小文件）
     * @param fileName
     */
    public static void printHex(String fileName) {
        FileInputStream in = null;
        int b;
        int i = 1;

        try {
            in = new FileInputStream(fileName);

            //-1表示文件结尾
            while ((b = in.read()) != -1) {
                //单位数前面补0
                if (b <= 0xff) {
                    System.out.print("0");
                }
                //转成16进制
                System.out.print(Integer.toHexString(b & 0xff) + " ");

                if (i++ % 10 == 0) {
                    System.out.println();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.FileInputStreamClose(in);
        }
    }

    /**
     * FileInputStream文件输入流
     * 批量字节读取（读取较大文件）【常用】
     * @param fileName
     */
    public static void printHexByByteArrays(String fileName) {
        FileInputStream in = null;
        byte[] buf = new byte[10 * 1024];

        int bytes;
        int j = 1;

        try {
            in = new FileInputStream(fileName);

            while ((bytes = in.read(buf, 0, buf.length)) != -1) {
                for (int i = 0; i < bytes; i++) {
                    System.out.print(Integer.toHexString(buf[i] & 0xff) + " ");
                    if (j++ % 10 == 0) {
                        System.out.println();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.FileInputStreamClose(in);
        }
    }

    /**
     * 关闭FileInputStream
     *
     * @param in
     */
    public static void FileInputStreamClose(FileInputStream in) {
        if (in != null) {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
