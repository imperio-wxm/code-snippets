package com.wxmimperio.jetty.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wxmimperio.jetty.pojo.Page;
import com.wxmimperio.jetty.serviceimpl.ReaderImpl;
import net.sf.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by weiximing.imperio on 2016/7/14.
 */
public class JettyServlet extends HttpServlet {

    private static ReaderImpl reader = null;

    public JettyServlet() {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            reader = new ReaderImpl();

            System.out.println("This is jetty servlet!!");
            response.setCharacterEncoding("utf-8");
            response.setContentType("application/json;charset=utf-8");

            String id = request.getParameter("id");
            String startLine = request.getParameter("startLine");
            String endline = request.getParameter("endLine");

            Page page = reader.read(id,startLine,endline);

            Map<String, Object> map = new HashMap<String,Object>();
            map.put("filename",page.getFilename());
            map.put("startLine",page.getStartLine());
            map.put("endLine",page.getEndLine());
            map.put("totalLine",page.getTotalLine());
            map.put("content",page.getContent());

            JSONObject jsonObject = JSONObject.fromObject(map);
            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().write(jsonObject.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
