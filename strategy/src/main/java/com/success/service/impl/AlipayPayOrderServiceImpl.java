package com.success.service.impl;

import com.success.common.ThirdPayNameEnum;
import com.success.service.PayOrderService;

/**
 * @Title：支付宝支付方式下订单
 * @Author：wangchenggong
 * @Date 2020/9/21 17:35
 * @Description
 * @Version
 */
public class AlipayPayOrderServiceImpl implements PayOrderService {

    @Override
    public ThirdPayNameEnum getThirdPayName() {
        return ThirdPayNameEnum.ALIPAY;
    }

    @Override
    public String orderPay(String reqContent) {
        return "支付宝下单成功,请求内容为:"+reqContent;
    }
}
