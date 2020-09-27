package com.success.dataAccess.service.impl;

import com.success.dataAccess.bean.Bank;
import com.success.dataAccess.dao.BaseMapper;
import com.success.dataAccess.service.AbstractService;
import com.success.dataAccess.service.BankService;
import org.springframework.stereotype.Service;

/**
 * @Title：银行信息服务接口实现类
 * @Author：wangchenggong
 * @Date 2020/9/27 10:14
 * @Description
 * @Version
 */
@Service
public class BankServiceImpl extends AbstractService<Long, Bank> implements BankService {
    //这里需要注入BankMapper

    @Override
    protected BaseMapper<Long, Bank> getBaseMapper() {
        return null;
    }
}
