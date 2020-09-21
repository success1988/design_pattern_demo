package com.success.component;

import cn.hutool.core.lang.ClassScanner;
import com.success.common.LoanComputeMethod;
import com.success.common.LoanMethodEnum;
import com.success.service.LoanComputeService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @Title：
 * @Author：wangchenggong
 * @Date 2020/9/22 6:58
 * @Description
 * @Version
 */
@Component
public class LoanComputeHandler implements BeanFactoryPostProcessor {

    private Map<LoanMethodEnum, LoanComputeService>  loanComputeServiceMap;

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        loanComputeServiceMap = new HashMap<>();
        //扫描com.success.service包，获取LoanComputeMethod注释被哪些类使用，将这些类存入map
        ClassScanner.scanPackageByAnnotation("com.success.service", LoanComputeMethod.class).forEach(clazz -> {
            LoanMethodEnum value = clazz.getAnnotation(LoanComputeMethod.class).value();
            loanComputeServiceMap.put(value, (LoanComputeService)configurableListableBeanFactory.getBean(clazz));
        });
    }

    public LoanComputeService getLoanComputeService(LoanMethodEnum loanMethodEnum){
        return loanComputeServiceMap.get(loanMethodEnum);
    }
}
