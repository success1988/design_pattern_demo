package com.success.dataAccess.bean;

import lombok.Getter;
import lombok.Setter;

/**
 * @Title：银行信息实体
 * @Author：wangchenggong
 * @Date 2020/9/27 10:04
 * @Description
 * @Version
 */
@Getter
@Setter
public class Bank {
    private Long id;
    private String bankCode;
    private String bankName;
}
