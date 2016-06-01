package com.fileopts;

import com.utils.GetPath;
import com.utils.IOUtils;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * Created by wxmimperio on 2016/6/1.
 */
public class DataStreamOpts {
    public static void main(String[] args) {

        GetPath getPath = new GetPath();
        //得到父级目录
        String oldFilePath = getPath.getCurrentPath() + "com/files/data_stream_test.txt";

        DataOutputStream dos = IOUtils.DataOutputStreamOpts(oldFilePath);
        DataInputStream dis = IOUtils.DataInputStreamOpts(oldFilePath);

        try {
            //采用utf-16be编码写入
            //dos.writeChars("");
            dos.writeUTF("采用UFT-8编码写入：123456 true");
            System.out.println(dis.readUTF());
            System.out.println(dis.readInt());
            System.out.println(dis.readBoolean());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.DataInputStreamClose(dis);
            IOUtils.DataOutputStreamClose(dos);
        }
    }
}
