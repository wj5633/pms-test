package com.wj5633.pms.controller;

import com.wj5633.pms.config.MyConfiguration;
import com.wj5633.pms.config.TestConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @author wj
 * @create 2018-08-21 13:35
 **/

@RestController
@Slf4j
//@EnableConfigurationProperties({MyConfiguration.class, TestConfiguration.class})
public class HelloWorld {
    @Value("${my.name}")
    private String name;
    @Value("${my.age}")
    private int age;

    private TestConfiguration test;
    private MyConfiguration myConfiguration;
    @Autowired
    public void setUser(TestConfiguration test) {
        this.test = test;
    }
    @Autowired
    public void setMyConfiguration(MyConfiguration myConfiguration) {
        this.myConfiguration = myConfiguration;
    }

    @ApiIgnore
    @GetMapping("/")
    public String index() {
        log.error("error");
        log.info("info");
        log.debug("debug");
        return "Hello World!";
    }

    @ApiIgnore
    @GetMapping("/miya")
    public String miya() {
        return name + ":" + age;
    }

    @ApiIgnore
    @GetMapping("/test")
    public String test() {
        return test.toString();
    }

    @ApiIgnore
    @GetMapping("/lucy")
    public String lucy() {
        return myConfiguration.toString();
    }
}
