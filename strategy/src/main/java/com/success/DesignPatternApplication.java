package com.success;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @Title：启动类
 * @Author：wangchenggong
 * @Date 2020/9/20 21:21
 * @Description
 * @Version
 */
@SpringBootApplication(scanBasePackages = {"com.success"})
public class DesignPatternApplication {
    public static void main(String[] args) {
        SpringApplication.run(DesignPatternApplication.class, args);
    }
}
