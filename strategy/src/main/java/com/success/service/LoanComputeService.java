package com.success.service;

import java.math.BigDecimal;

/**
 * @Title：贷款计算服务
 * @Author：wangchenggong
 * @Date 2020/9/21 18:48
 * @Description
 * @Version
 */
public interface LoanComputeService {


    /**
     * 计算每月还款额度
     * @param totalAmount 总借款额度
     * @param months 还款期数
     * @param yearRate 年化利率
     * @return
     */
    public BigDecimal computeMonthAmount(BigDecimal totalAmount, int months, BigDecimal yearRate);
}
