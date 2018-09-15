package com.wj5633.pms.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author wj
 * @create 2018-09-14 23:24
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class IRedisServiceTest {

    private IRedisService iRedisService;

    @Autowired
    public void setiRedisService(IRedisService iRedisService) {
        this.iRedisService = iRedisService;
    }

    @Test
    public void set() {
        boolean result= iRedisService.set("name", "wangjie");
        System.out.println(result);
    }

    @Test
    public void setWithExpire() {
        boolean result= iRedisService.set("age", "18", 60L);
        System.out.println(result);
    }

    @Test
    public void get() {
        String result = (String) iRedisService.get("name");
        System.out.println(result);
    }

    @Test
    public void exists() {
        boolean result= iRedisService.exists("name");
        System.out.println(result);
    }

    @Test
    public void remove() {
        boolean result= iRedisService.remove("name");
        System.out.println(result);
    }

    @Test
    public void removeAll() {
       iRedisService.set("name", "wangjie");
       iRedisService.set("name", "18");

       iRedisService.remove("name", "age");
    }
}
