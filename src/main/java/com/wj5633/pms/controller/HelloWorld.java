package com.wj5633.pms.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wj
 * @create 2018-08-21 13:35
 **/

@RestController
@Slf4j
public class HelloWorld {

    @RequestMapping("/")
    public String index() {
        log.error("error");
        log.info("info");
        log.debug("debug");
        return "Hello World!";
    }
}
