package com.success.component;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @Title：获取bean的工具类
 * @Author：wangchenggong
 * @Date 2020/9/20 21:46
 * @Description
 * @Version
 */
@Component
public class BeanTool implements ApplicationContextAware {


    /**
     * Spring IOC容器
     */
    private static ApplicationContext applicationContext = null;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        BeanTool.applicationContext = applicationContext;
    }


    public static Object getBean(String beanId) throws BeansException{
        return applicationContext.getBean(beanId);
    }

    public  static <T> T getBean(Class<T> clazz) throws BeansException{
        return applicationContext.getBean(clazz);
    }

    public  static <T> T getBean(String beanId, Class<T> clazz) throws BeansException{
        return applicationContext.getBean(beanId, clazz);
    }



}
