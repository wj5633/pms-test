package com.wj5633.pms.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wj
 * @create 2018-08-21 13:35
 **/

@RestController
@Slf4j
public class HelloWorld {

    @RequestMapping("/")
    public Map<String, Object> index() {
        log.error("error");
        log.info("info");
        Map<String, Object> map = new HashMap<>();
        map.put("name", "wangjie");
        map.put("age", 18);
        return map;
    }
}
