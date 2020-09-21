package com.success.service;

import com.success.common.ThirdPayNameEnum;
import com.success.component.PayOrderServiceFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Title：spi 服务接口策略模式 测试用例
 * @Author：wangchenggong
 * @Date 2020/9/21 17:54
 * @Description
 * @Version
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PayOrderServiceTest {

    @Autowired
    private PayOrderServiceFactory payOrderServiceFactory;

    @Test
    public void testStrategy3() {

        ThirdPayNameEnum thirdPayNameEnum = ThirdPayNameEnum.WXPAY;
        PayOrderService payOrderService = payOrderServiceFactory.getPayOrderServiceByThirdName(thirdPayNameEnum.getName());
        //调用支付
        String result = payOrderService.orderPay("手机 1190元");
        System.out.println("支付结果:" + result);

    }
}