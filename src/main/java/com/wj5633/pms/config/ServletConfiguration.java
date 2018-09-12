package com.wj5633.pms.config;

import com.wj5633.pms.filter.MyFilter;
import com.wj5633.pms.listener.MyContextListener;
import com.wj5633.pms.servlet.MyServlet;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author wj
 * @create 2018-09-06 20:14
 **/

@SpringBootConfiguration
public class ServletConfiguration {

    @Bean
    public ServletRegistrationBean<MyServlet> createMyServlet() {
        ServletRegistrationBean<MyServlet> servletRegistrationBean = new ServletRegistrationBean<>();
        servletRegistrationBean.setServlet(new MyServlet());
        servletRegistrationBean.addUrlMappings("/my");
        return servletRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean<MyFilter> createMyFilter() {
        FilterRegistrationBean<MyFilter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new MyFilter());
        filterRegistrationBean.addUrlPatterns("/my");
        return filterRegistrationBean;
    }

    @Bean
    public ServletListenerRegistrationBean<MyContextListener> createMyContextListener() {
        ServletListenerRegistrationBean<MyContextListener> servletListenerRegistrationBean = new ServletListenerRegistrationBean<>();

        servletListenerRegistrationBean.setListener(new MyContextListener());
        return servletListenerRegistrationBean;
    }
}
