package com.wj5633.pms.command;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author wj
 * @create 2018-09-06 14:11
 **/

@Slf4j
@Component
@Order(50)
public class StartedApplicationRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("应用启动, 参数是: ", Arrays.asList(args.getSourceArgs()));
    }
}
