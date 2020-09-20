package com.success.service.impl;

import com.success.bean.Account;
import com.success.common.AccountBizType;
import com.success.service.AccountChangeService;
import org.springframework.stereotype.Service;

/**
 * @Title：处理下单类型的账户变更
 * @Author：wangchenggong
 * @Date 2020/9/21 6:02
 * @Description
 * @Version
 */
@Service(AccountBizType.ACCOUNT_BIZ_TYPE_PAY_ORDER)
public class AccountPayOrderServiceImpl implements AccountChangeService {
    @Override
    public void doChange(Account targetAccount) {
        System.out.println("执行账户变更：下单业务处理");
    }
}
