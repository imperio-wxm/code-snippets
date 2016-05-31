package com.fileopts;

import com.utils.FileUtils;
import com.utils.GetPath;

import java.io.File;
import java.io.IOException;

/**
 * Created by wxmimperio on 2016/5/31.
 */
public class FileOptsTest {
    public static void main(String[] args) {
        GetPath getPath = new GetPath();

        String file_path = getPath.getCurrentPath();

        System.out.println(file_path);

        try {
            FileUtils.listDirectory(new File(file_path));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
