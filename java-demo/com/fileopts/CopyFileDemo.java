package com.fileopts;

import com.utils.GetPath;
import com.utils.IOUtils;

/**
 * Created by wxmimperio on 2016/6/1.
 */
public class CopyFileDemo {
    public static void main(String[] args) {
        GetPath getPath = new GetPath();
        //得到父级目录
        String oldFilePath = getPath.getCurrentPath() + "com/files/file_test.txt";

        String newFilePath = getPath.getCurrentPath() + "com/files/copy_test.txt";

        IOUtils.copyFiles(oldFilePath, newFilePath);
    }
}
