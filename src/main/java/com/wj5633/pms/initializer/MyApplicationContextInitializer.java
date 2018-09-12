package com.wj5633.pms.initializer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author wj
 * @create 2018-09-06 13:29
 **/

@Slf4j
public class MyApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        log.info("bean count: " + applicationContext.getBeanDefinitionCount());
    }
}
