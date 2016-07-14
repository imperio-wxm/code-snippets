package com.wxmimperio.jetty.serviceimpl;

import com.wxmimperio.jetty.pojo.Page;
import com.wxmimperio.jetty.service.Reader;
import com.wxmimperio.jetty.utils.FolderUtil;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
            date = simpleDateFormat.parse("2016-06-25 15:19:24");
            SimpleDateFormat sdfTxt = new SimpleDateFormat("yyyyMMddHHmmss");
            String timeStemp = sdfTxt.format(date);
            System.out.println(timeStemp);

            filename = id + DOT + timeStemp + TXT;

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
        } catch (ParseException parseException) {
            parseException.printStackTrace();
        }
        return page;
    }
}
