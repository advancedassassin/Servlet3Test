package com.ydx.servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @ClassName UserListener
 * @Description 描述一下该类用途
 * @Author Duxin Yuan
 * @Date 2020/10/29 17:37
 * @Version 1.0
 **/
public class UserListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("UserListener...contextInitialized");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("UserListener...contextDestroyed");
    }
}
