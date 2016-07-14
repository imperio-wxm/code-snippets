package com.wxmimperio.jetty.main;
import com.wxmimperio.jetty.servlet.JettyServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;


/**
 * Created by weiximing.imperio on 2016/7/14.
 */
public class JettyMain {

    public static void main(String[] args) {
        try {
            Server httpServer = new Server(8099);
            ServletContextHandler context = new ServletContextHandler(
                    ServletContextHandler.SESSIONS);
            context.setContextPath("/");
            context.addServlet(new ServletHolder(new JettyServlet()), "/userServlet");

            httpServer.setHandler(context);

            System.out.println("[jetty start at localhost]: 8099");
            httpServer.start();
            httpServer.join();
        } catch (Exception e) {
            System.out.println("[jetty start at localhost]: 8099 fail");
        }
    }
}
