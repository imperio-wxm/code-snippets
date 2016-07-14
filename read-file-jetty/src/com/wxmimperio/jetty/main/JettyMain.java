package com.wxmimperio.jetty.main;

import com.wxmimperio.jetty.servlet.JettyServlet;
import org.apache.commons.lang.StringUtils;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import com.wxmimperio.jetty.utils.PropertyUtil;

/**
 * Created by weiximing.imperio on 2016/7/14.
 */
public class JettyMain {

    private static int port = 8099;

    static {
        //从配置文件读取port
        String p = PropertyUtil.getInstance().getProperty("jetty.local.port");
        try {
            if (StringUtils.isNotBlank(p)) {
                port = Integer.valueOf(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            Server httpServer = new Server(port);
            ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
            context.setContextPath("/");
            context.addServlet(new ServletHolder(new JettyServlet()), "/fileServlet");

            httpServer.setHandler(context);

            System.out.println("[jetty start at localhost]: " + port);
            httpServer.start();
            httpServer.join();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("[jetty start at localhost]: " + port + " fail");
        }
    }
}
