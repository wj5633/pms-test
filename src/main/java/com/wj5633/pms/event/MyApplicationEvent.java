package com.wj5633.pms.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author wj
 * @create 2018-09-06 12:58
 **/
public class MyApplicationEvent extends ApplicationEvent {
    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public MyApplicationEvent(Object source) {
        super(source);
    }
}
