package com.success.service.impl;

import com.success.bean.Account;
import com.success.common.AccountBizType;
import com.success.service.AccountChangeService;
import org.springframework.stereotype.Service;

/**
 * @Title：处理提现类型的账户变更
 * @Author：wangchenggong
 * @Date 2020/9/21 6:02
 * @Description
 * @Version
 */
@Service(AccountBizType.ACCOUNT_BIZ_TYPE_WITHDRAW)
public class AccountWithdrawServiceImpl implements AccountChangeService {
    @Override
    public void doChange(Account targetAccount) {
        System.out.println("执行账户变更：提现业务处理");
    }
}
