package com.success.service.impl;

import com.success.service.LoanComputeService;

import java.math.BigDecimal;

/**
 * @Title：等额本金还款法
 * @Author：wangchenggong
 * @Date 2020/9/21 18:53
 * @Description
 * @Version
 */
public class AverageCapitalMethod implements LoanComputeService {

    @Override
    public BigDecimal computeMonthAmount(BigDecimal totalAmount, int months, BigDecimal yearRate) {
        return null;
    }
}
