package com.wj5633.pms.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author wj
 * @create 2018-09-06 13:09
 **/

@Slf4j
@Component
public class MyEventHandler {

    @EventListener
    public void event(Object event) {
        log.info("Event: " + event.getClass().getName());
    }
}
