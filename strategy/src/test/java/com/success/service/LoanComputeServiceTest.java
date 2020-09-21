package com.success.service;

import org.junit.Test;
import com.success.common.LoanMethodEnum;
import com.success.component.LoanComputeHandler;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Title：基于注解扫描的策略模式
 * @Author：wangchenggong
 * @Date 2020/9/22 7:17
 * @Description
 * @Version
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LoanComputeServiceTest {

    @Autowired
    private LoanComputeHandler loanComputeHandler;
    @Test
    public void testStrategy4() {

        LoanComputeService loanComputeService = loanComputeHandler.getLoanComputeService(LoanMethodEnum.AverageCapitalMethod);
        loanComputeService.computeMonthAmount(BigDecimal.ONE, 12, BigDecimal.TEN);

    }
}