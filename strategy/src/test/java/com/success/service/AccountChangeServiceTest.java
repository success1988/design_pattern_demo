package com.success.service;


import com.success.bean.Account;
import com.success.common.AccountBizType;
import com.success.component.AccountChangeHandler;
import com.success.component.BeanTool;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Title：账户变更服务单元测试
 * @Author：wangchenggong
 * @Date 2020/9/21 6:11
 * @Description
 * @Version
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountChangeServiceTest {

    @Autowired
    private AccountChangeHandler accountChangeHandler;

    @Test
    public void testStrategy1(){

        String accountBizType = AccountBizType.ACCOUNT_BIZ_TYPE_RECHARGE;
        Account account = new Account();
        //根据账户变更业务类型找到对应的变更服务（这里就是策略模式）
        AccountChangeService accountChangeService = (AccountChangeService) BeanTool.getBean(accountBizType);
        //执行账户变更
        accountChangeService.doChange(account);
    }

    @Test
    public void testStrategy2(){

        String accountBizType = AccountBizType.ACCOUNT_BIZ_TYPE_WITHDRAW;
        Account account = new Account();
        //根据账户变更业务类型找到对应的变更服务（这里就是策略模式）
        AccountChangeService accountChangeService = accountChangeHandler.getAccountChangeService(accountBizType);
        //执行账户变更
        accountChangeService.doChange(account);
    }
}