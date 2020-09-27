package com.success.dataAccess.bean;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @Title：账户信息实体
 * @Author：wangchenggong
 * @Date 2020/9/27 10:05
 * @Description
 * @Version
 */
@Getter
@Setter
public class AccountInfo {

    private Long id;
    private String accountNo;
    private BigDecimal balance;
}
