package com.wxmimperio.jetty.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by weiximing.imperio on 2016/7/14.
 */
public class Page {
    private String filename;//文件名
    private int startLine = 0; // 开始行号
    private int endLine = 0; // 结束行号
    private int totalLine = 0; // 共多少行
    private List<String> content = new ArrayList<String>(); // 文本内容

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public int getStartLine() {
        return startLine;
    }

    public void setStartLine(int startLine) {
        this.startLine = startLine;
    }

    public int getEndLine() {
        return endLine;
    }

    public void setEndLine(int endLine) {
        this.endLine = endLine;
    }

    public int getTotalLine() {
        return totalLine;
    }

    public void setTotalLine(int totalLine) {
        this.totalLine = totalLine;
    }

    public List<String> getContent() {
        return content;
    }

    public void setContent(List<String> content) {
        this.content = content;
    }
}
