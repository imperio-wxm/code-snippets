package com.wxmimperio;

/**
 * Created by wxmimperio on 2016/5/31.
 */
public class EncodeDemo {
    public static void main(String[] args) throws Exception{
        String str = "测试imperio";

        //以utf-8编码时，中文占用3个字节，英文占用一个字节
        byte[] bytes1 = str.getBytes("utf-8");
        for (byte b : bytes1) {
            //将字节转换成Int，以16进制的方式显示
            System.out.print(Integer.toHexString(b & 0xff) + " ");
        }

        System.out.println();

        //以gbk编码时，中文占用2个字节，英文占用一个字节
        byte[] bytes2 = str.getBytes("gbk");
        for (byte b : bytes2) {
            System.out.print(Integer.toHexString(b & 0xff) + " ");
        }

        System.out.println();

        //java是双字节编码(utf-16be)
        //以utf-16be编码，中文占用两个字节，英文占用两个字节
        byte[] bytes3 = str.getBytes("utf-16be");

        for (byte b: bytes3) {
            System.out.print(Integer.toHexString(b & 0xff) + " ");
        }

        System.out.println();

        /**
         * 当你的字节序列是某种编码时，这个时候想要把字节序列变成字符串
         * 也需要用这种编码，否则会出现乱码
         */
        String str1 = new String(bytes3);//用项目默认的编码(utf-8)，会出现乱码
        String str2 = new String(bytes3, "utf-16be");
        System.out.println(str1 + " " + str2);

        /**
         * 文本文件就是字节序列
         * 可以是任意编码的字节序列
         * 如果我们在中文机器上直接创建文本文件，那么该文本文件默认只认识ansi编码
         */
    }
}
