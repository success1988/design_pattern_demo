package com.success.component;

import com.success.service.AccountChangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Title：账户变更服务处理类
 * @Author：wangchenggong
 * @Date 2020/9/21 6:41
 * @Description
 * @Version
 */
@Component
public class AccountChangeHandler {


    @Autowired
    private Map<String, AccountChangeService> map;

    public AccountChangeService getAccountChangeService(String beanId){
        return map.get(beanId);
    }

}
