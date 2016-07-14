package com.wxmimperio.jetty.serviceimpl;

import com.wxmimperio.jetty.pojo.Page;
import com.wxmimperio.jetty.service.Reader;
import com.wxmimperio.jetty.utils.FolderUtil;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.RegexFileFilter;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Created by weiximing.imperio on 2016/7/14.
 */
public class ReaderImpl implements Reader {

    private static final String TXT = ".txt";
    private static final String DOT = ".";

    @Override
    public Page read(String id, String startLine, String endLine) {
        Page page = new Page();
        String path = FolderUtil.getLogPath();
        String filename = "";
        int totalLine = 0;
        List<String> content = new ArrayList<String>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;

        try {
            int start = Integer.valueOf(startLine);
            int end = Integer.valueOf(endLine);

            /*
                最初通过设定时间来获取最新的文件
                date = simpleDateFormat.parse("2016-06-25 15:19:24");
                SimpleDateFormat sdfTxt = new SimpleDateFormat("yyyyMMddHHmmss");
                String timeStemp = sdfTxt.format(date);
                System.out.println(timeStemp);
            */

            String lastFile = getLastFile(path, id, DOT);

            filename = id + DOT + lastFile + TXT;

            File file = new File(path + "/" + filename);
            page.setFilename(filename);
            if (file.exists() && file.canRead()) {
                List<String> lines = null;
                lines = FileUtils.readLines(file, "utf-8");
                totalLine = lines.size();// 总长

                //3.添加 [start,end) 范围内的行
                if (end >= totalLine) {
                    end = totalLine;//防止下标越界
                }
                for (int i = 0; i < end; i++) {
                    if (i < start) {
                        //略过开始行
                        continue;
                    }
                    content.add(lines.get(i));
                }
                page.setStartLine(start);
                page.setEndLine(end);
                page.setTotalLine(totalLine);
                page.setContent(content);
            }

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return page;
    }

    private String getLastFile(String path, String id, String txt) {
        String filepath = "^" + id + ".*" + txt;
        File dir = new File(path);

        FileFilter fileFilter = new RegexFileFilter(filepath);
        File[] files = dir.listFiles(fileFilter);
        List list = new ArrayList();
        String fileName = null;

        for (int i = 0; i < files.length; i++) {
            list.add(Long.valueOf(files[i].getName().split("\\.")[1]).longValue());
        }
        Collections.sort(list);
        fileName = list.get(list.size() - 1).toString();
        System.out.println(fileName);
        return fileName;
    }
}
