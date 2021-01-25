package com.success.route_validator.impl;

import org.springframework.stereotype.Component;
import com.success.route_validator.BaseRouteValidator;
import com.success.route_validator.Channel;

/**
 * @Title：路由失败次数校验器
 * @Author：wangchenggong
 * @Date 2021/1/25 11:35
 * @Description
 * @Version
 */
@Component
public class FailTimesRouteValidatorImpl implements BaseRouteValidator {

    @Override
    public boolean validate(Channel channel) {
        //TODO 这里校验当前路由是否满足路由失败次数的要求,不能超出系统配置的最大次数
        return true;
    }

    @Override
    public int getPriority() {
        return 2;
    }
}
