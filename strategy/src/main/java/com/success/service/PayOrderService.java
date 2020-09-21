package com.success.service;

import com.success.common.ThirdPayNameEnum;

/**
 * @Title：支付订单服务
 * @Author：wangchenggong
 * @Date 2020/9/21 17:28
 * @Description
 * @Version
 */
public interface PayOrderService {

    public ThirdPayNameEnum getThirdPayName();

    public String orderPay(String reqContent);
}
