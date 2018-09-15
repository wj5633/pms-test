package com.wj5633.pms.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author wj
 * @create 2018-09-12 23:28
 **/
@ConfigurationProperties(prefix = "my")
@Component
@Data
public class MyConfiguration {
    private String name;
    private int age;
    private int number;
    private String uuid;
    private int max;
    private String value;
    private String greeting;
}
