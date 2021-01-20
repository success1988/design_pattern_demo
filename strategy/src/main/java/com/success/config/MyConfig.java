package com.success.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Title：
 * @Author：wangchenggong
 * @Date 2020/10/12 11:07
 * @Description
 * @Version
 */
@Configuration
public class MyConfig {
    @Bean
    public MyService createMyService(){
        return new MyService();
    }
}
