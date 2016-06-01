package com.fileopts;

import com.utils.GetPath;
import com.utils.IOUtils;

/**
 * Created by wxmimperio on 2016/6/1.
 */
public class IODemo {
    public static void main(String[] args) {
        GetPath getPath = new GetPath();
        //得到父级目录
        String file_path = getPath.getCurrentPath() + "com/files/file_test.txt";

        IOUtils.printHex(file_path);

        System.out.println("\n---------------------");

        IOUtils.printHexByByteArrays(file_path);
    }
}
