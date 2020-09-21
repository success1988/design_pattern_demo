package com.success.component;

import com.success.service.PayOrderService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.ServiceLoader;

/**
 * @Title：三方支付服务实例工厂
 * @Author：wangchenggong
 * @Date 2020/9/21 17:43
 * @Description
 * @Version
 */
@Component
public class PayOrderServiceFactory implements InitializingBean {


    /**
     * 支付服务map
     */
    private static final Map<String, PayOrderService> payOrderServiceMap = new HashMap<>();


    public PayOrderService getPayOrderServiceByThirdName(String thirdName){
        return payOrderServiceMap.get(thirdName);
    }


    /**
     * 在spring的实例初始化时，利用jdk的SPI机制加载接口的所有实现，并存入map集合
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {

        ServiceLoader<PayOrderService> payOrderServices = ServiceLoader.load(PayOrderService.class);
        for(PayOrderService payOrderService : payOrderServices){
            payOrderServiceMap.put(payOrderService.getThirdPayName().getName(), payOrderService);
        }

    }
}
