package com.wj5633.pms.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author wj
 * @create 2018-09-06 12:58
 **/

@Slf4j
//@Component
public class MyApplicationListener implements ApplicationListener<MyApplicationEvent> {
    @Override
    public void onApplicationEvent(MyApplicationEvent event) {

        log.info("Event: " + event.getClass().getName());
    }
}
