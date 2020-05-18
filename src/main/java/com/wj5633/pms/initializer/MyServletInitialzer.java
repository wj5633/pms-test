package com.wj5633.pms.initializer;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.util.Set;

/**
 * @author wj
 * @create 2018-09-06 20:09
 **/

@Slf4j
public class MyServletInitialzer implements ServletContainerInitializer {
    @Override
    public void onStartup(Set<Class<?>> set, ServletContext servletContext) throws ServletException {
        log.info("My Servlet Initialzer" + servletContext.getContextPath());
    }
}
