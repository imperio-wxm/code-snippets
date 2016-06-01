package com.fileopts;

import com.utils.GetPath;
import com.utils.IOUtils;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by wxmimperio on 2016/6/1.
 */
public class FileReaderWriter {
    public static void main(String[] args) {

        int c;
        char[] buffer = new char[10 * 1024];
        GetPath getPath = new GetPath();

        //得到父级目录
        String oldFilePath = getPath.getCurrentPath() + "com/files/file_test.txt";
        String newFilePath = getPath.getCurrentPath() + "com/files/fw_fr_test.txt";

        FileReader fr = IOUtils.FileReaderOpt(oldFilePath);
        FileWriter fw = IOUtils.FileWriterOpt(newFilePath);

        try {
            while ((c = fr.read(buffer, 0, buffer.length)) != -1) {
                fw.write(buffer, 0, c);
                fw.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.FileWriterClose(fw);
            IOUtils.FileReaderClose(fr);
        }
    }
}
