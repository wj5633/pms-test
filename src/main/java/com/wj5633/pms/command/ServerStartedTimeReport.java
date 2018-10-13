package com.wj5633.pms.command;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author wj
 * @create 2018-09-06 14:06
 **/

@Slf4j
@Component
@Order(100)
public class ServerStartedTimeReport implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        log.info("============应用启动时间：" + LocalDateTime.now());
    }
}
