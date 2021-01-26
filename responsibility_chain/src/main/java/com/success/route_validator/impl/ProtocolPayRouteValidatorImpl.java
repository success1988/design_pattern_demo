package com.success.route_validator.impl;

import org.springframework.stereotype.Component;
import com.success.route_validator.PayRouteValidator;
import com.success.route_validator.Channel;

/**
 * @Title：协议号校验器，对于协议支付，必须要能查到用户的协议号
 * @Author：wangchenggong
 * @Date 2021/1/25 11:21
 * @Description
 * @Version
 */
@Component
public class ProtocolPayRouteValidatorImpl implements PayRouteValidator {

    @Override
    public boolean validate(Channel channel) {
        //TODO 这里校验用户的协议号是否存在（如果当前的交易类型为协议支付时）
        return true;
    }

    @Override
    public int getPriority() {
        return 4;
    }
}
