package com.example.config;

import com.example.plugin.MybatisSqlPrintPlugin;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Title：mybatis的全局配置，相当于是mybatis-config.xml
 * @Author：wangchenggong
 * @Date 2021/2/10 10:23
 * @Description
 * @Version
 */
@Configuration
public class MybatisConfig {

    @Bean
    public MybatisSqlPrintPlugin mybatisSqlPrintPlugin(){
        return new MybatisSqlPrintPlugin();
    }

    @Bean
    public ConfigurationCustomizer configurationCustomizer(){
        return new ConfigurationCustomizer() {
            @Override
            public void customize(org.apache.ibatis.session.Configuration configuration) {
                //注册MyBatis的插件
                configuration.addInterceptor(mybatisSqlPrintPlugin());
            }
        };
    }

}
