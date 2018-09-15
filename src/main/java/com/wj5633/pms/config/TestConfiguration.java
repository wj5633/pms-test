package com.wj5633.pms.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author wj
 * @create 2018-09-13 0:12
 **/
@Configuration
@PropertySource(value = "classpath:test.properties")
@ConfigurationProperties(prefix = "com.wj5633")
@Data
public class TestConfiguration {
    private String name;
    private int age;
}
