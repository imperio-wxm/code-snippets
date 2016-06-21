package com.wxmimperio;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

/**
 * Created by weiximing.imperio on 2016/6/21.
 */
public class ReadFileDemo {
    public static void main(String args[]) {
        Map<String, String> map = new HashMap<String, String>();
        String pathname = "D:\\test.txt"; // 绝对路径或相对路径都可以，这里是绝对路径，写入文件时演示相对路径
        String leechDocName;
        String leechDocCnName;
        String leechOriginalName;
        String leechIncField;
        String leechDocExtraction;

        try {
            String leechDocSummaryDetails = ReadFileDemo.readFile(pathname);
            String[] lines = leechDocSummaryDetails.split("\\u000A");
            List filedsList = new ArrayList();

            for (String line : lines) {
                if (leechDocSummaryDetails.equals("")) {
                    System.out.println("ERROR-数据摘要行内容不能为空，请检查");
                    return;
                }
                String[] fileds = line.split("\\u0009");
                for (String filed : fileds) {
                    filedsList.add(filed);
                }
            }

            if (filedsList.get(5).equals("全量")) {
                filedsList.add("");
            }
            if (filedsList.size() != 8) {
                System.out.println("ERROR-数据摘要行内容必须复制完整，必须有8个字段");
                return;
            }
            System.out.println(filedsList);
            //数据中文名称
            map.put("leechDocCnName", filedsList.get(0).toString());
            //数据名
            map.put("leechDocName", filedsList.get(1).toString());
            //原始表名
            map.put("leechOriginalName", filedsList.get(3).toString());
            //抽取类型
            map.put("leechDocExtraction", filedsList.get(5).toString());
            //增量字段
            map.put("leechIncField", filedsList.get(7).toString());

            leechDocName = map.get("leechDocName").toLowerCase();
            leechDocCnName = map.get("leechDocCnName");
            leechOriginalName = map.get("leechOriginalName");
            leechIncField = map.get("leechIncField");
            if (map.get("leechDocExtraction").equals("增量")) {
                leechDocExtraction = "2";
            } else {
                leechDocExtraction = "1";
            }

            System.out.println(leechDocCnName);
            System.out.println(leechDocName);
            System.out.println(leechOriginalName);
            System.out.println(leechIncField);
            System.out.println(leechDocExtraction);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readToBuffer(StringBuffer buffer, String filePath) throws IOException {
        InputStream is = new FileInputStream(filePath);
        String line; // 用来保存每行读取的内容
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        line = reader.readLine(); // 读取第一行
        while (line != null) { // 如果 line 为空说明读完了
            buffer.append(line); // 将读到的内容添加到 buffer 中
            buffer.append("\n"); // 添加换行符
            line = reader.readLine(); // 读取下一行
        }
        reader.close();
        is.close();
    }

    public static String readFile(String filePath) throws IOException {
        StringBuffer sb = new StringBuffer();
        ReadFileDemo.readToBuffer(sb, filePath);
        return sb.toString();
    }
}
