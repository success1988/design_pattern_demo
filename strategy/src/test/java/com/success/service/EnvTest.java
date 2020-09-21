package com.success.service;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Title：环境隔离单元测试
 * @Author：wangchenggong
 * @Date 2020/9/21 6:11
 * @Description
 * @Version
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EnvTest {


    @Value("${spring.profiles.active}")
    private String env;


    @Value("${spring.profiles}")
    private String currentEnv;


    @Test
    public void testEnv(){
        System.out.println("spring.profiles.active:"+env);
        System.out.println("spring.profiles:"+currentEnv);
    }

}