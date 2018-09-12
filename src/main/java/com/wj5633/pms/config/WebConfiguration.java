package com.wj5633.pms.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.wj5633.pms.interceptor.MyHandlerInterceptor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wj
 * @create 2018-09-06 21:18
 **/

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyHandlerInterceptor());
    }
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        // 1.需要先定义一个convert 转换消息的对象
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
        // 2.添加fastJson的配置信息,比如，是否需要格式化返回的json数据
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat, SerializerFeature.WriteNullListAsEmpty,
                SerializerFeature.WriteNullStringAsEmpty);
        List<MediaType> fastMediaTypes = new ArrayList<>();
        fastMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        fastConverter.setSupportedMediaTypes(fastMediaTypes);
        // 3.在convert中添加配置信息
        fastConverter.setFastJsonConfig(fastJsonConfig);
        // 4.将convert添加到converters当中
        converters.add(fastConverter);
    }
}
