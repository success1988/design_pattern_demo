package com.success.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @Title：自定义配置项
 * @Author：wangchenggong
 * @Date 2020/9/24 17:45
 * @Description
 * @Version
 */
@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "success")
public class SuccessConfig {

    private String name;
    private int age;

    @Bean
    public MyService createMyService(){
        return new MyService();
    }

}
