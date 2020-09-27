package com.success.dataAccess.service.impl;

import com.success.dataAccess.bean.AccountInfo;
import com.success.dataAccess.dao.BaseMapper;
import com.success.dataAccess.service.AbstractService;
import com.success.dataAccess.service.AccountInfoService;
import org.springframework.stereotype.Service;

/**
 * @Title：账户信息服务接口实现类
 * @Author：wangchenggong
 * @Date 2020/9/27 10:18
 * @Description
 * @Version
 */
@Service
public class AccountInfoServiceImpl extends AbstractService<Long, AccountInfo> implements AccountInfoService {
    //这里需要注入AccountInfoMapper

    @Override
    protected BaseMapper<Long, AccountInfo> getBaseMapper() {
        return null;
    }
}
