package com.success.service.impl;

import com.success.common.LoanComputeMethod;
import com.success.common.LoanMethodEnum;
import com.success.service.LoanComputeService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @Title：等额本金还款法
 * @Author：wangchenggong
 * @Date 2020/9/21 18:53
 * @Description
 * @Version
 */
@Service
@LoanComputeMethod(LoanMethodEnum.AverageCapitalMethod)
public class AverageCapitalMethod implements LoanComputeService {

    @Override
    public BigDecimal computeMonthAmount(BigDecimal totalAmount, int months, BigDecimal yearRate) {
        System.out.println("等额本金还款法 计算每月还款额度");
        return null;
    }
}
