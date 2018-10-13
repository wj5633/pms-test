package com.wj5633.pms.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author wj
 * @create 2018-09-06 19:58
 **/

//@WebListener
public class MyContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("My Context Initial" + servletContextEvent.getServletContext().getContextPath());
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("My Context Destroy" + servletContextEvent.getServletContext().getServletContextName());
    }
}
