package com.fileopts;

import com.utils.GetPath;
import com.utils.IOUtils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Created by wxmimperio on 2016/6/1.
 */
public class StreamWriterReader {
    public static void main(String[] args) {

        int c;
        char[] buffer = new char[10 * 1024];
        GetPath getPath = new GetPath();

        //得到父级目录
        String oldFilePath = getPath.getCurrentPath() + "com/files/file_test.txt";
        String newFilePath = getPath.getCurrentPath() + "com/files/writer_reader_test.txt";

        InputStreamReader isr = IOUtils.InputStreamReaderOpt(oldFilePath);
        OutputStreamWriter osw = IOUtils.OutputStreamWriterOpt(newFilePath);

        try {
            //批量读取字符，将读取到的字符放入字符数组的缓冲区，最多可以放字符数组长度的大小
            while ((c = isr.read(buffer, 0, buffer.length)) != -1) {
                String str = new String(buffer, 0, c);
                osw.write(str);
                osw.flush();
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.InputStreamReaderClose(isr);
            IOUtils.OutputStreamWriterClose(osw);
        }

    }
}
