package com.wxmimperio.jetty.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wxmimperio.jetty.serviceimpl.Result2JsonImpl;
import net.sf.json.JSONObject;


/**
 * Created by weiximing.imperio on 2016/7/14.
 */
public class JettyServlet extends HttpServlet {

    private Result2JsonImpl result2JsonImpl = null;

    public JettyServlet() {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            result2JsonImpl = new Result2JsonImpl();

            System.out.println("This is jetty servlet!!");
            response.setCharacterEncoding("utf-8");
            response.setContentType("application/json;charset=utf-8");

            String id = request.getParameter("id");
            String username = request.getParameter("username");
            String age = request.getParameter("age");
            String gender = request.getParameter("gender");

            JSONObject jsonObject = result2JsonImpl.result2Json(id, username, age, gender);

            //永远返回200,代表系统正常
            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().write(jsonObject.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
