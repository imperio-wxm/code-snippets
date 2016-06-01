package com.fileopts;

import com.utils.GetPath;
import com.utils.IOUtils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;

/**
 * Created by wxmimperio on 2016/6/1.
 */
public class CopyFileByBuffered {
    public static void main(String[] args) {
        int c;
        GetPath getPath = new GetPath();

        //得到父级目录
        String oldFilePath = getPath.getCurrentPath() + "com/files/file_test.txt";
        String newFilePath = getPath.getCurrentPath() + "com/files/buffered_test.txt";

        BufferedInputStream bis = IOUtils.BufferedInputStreamOpts(oldFilePath);
        BufferedOutputStream bos = IOUtils.BufferedOutputStreamOpts(newFilePath);

        try {
            while ((c = bis.read()) != -1) {
                bos.write(c);
                //强制刷新缓冲
                bos.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.BufferedInputStreamClose(bis);
            IOUtils.BufferedOutputStreamClose(bos);
        }
    }
}
