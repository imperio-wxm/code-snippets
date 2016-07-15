package com.wxmimperio.jetty.utils;

import org.apache.commons.io.filefilter.RegexFileFilter;
import org.apache.commons.lang.StringUtils;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FolderUtil {

    private static String local_log_path = "c:";//默认路径

    static {
        String prop_path = PropertyUtil.getInstance().getProperty("local.log.path");
        if (StringUtils.isNotBlank(prop_path)) {
            local_log_path = prop_path;
        }
    }

    public static String getLogPath() {
        return local_log_path;
    }

    public static String getLastFile(String path, String id, String txt) {
        String filepath = "^" + id + ".*" + txt;

        File dir = new File(path);
        String fileName = null;

        FileFilter fileFilter = new RegexFileFilter(filepath);
        File[] files = dir.listFiles(fileFilter);

        if (dir.length() != 0) {
            List list = new ArrayList();

            for (int i = 0; i < files.length; i++) {
                list.add(Long.valueOf(files[i].getName().split("\\.")[1]).longValue());
            }
            if (list.isEmpty()) {
                fileName = "";
            } else {
                Collections.sort(list);
                fileName = list.get(list.size() - 1).toString();
            }
            System.out.println(fileName);
            return fileName;
        } else {
            fileName = "";
            return fileName;
        }
    }
}
