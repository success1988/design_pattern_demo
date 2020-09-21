package com.success.common;

import java.util.Arrays;
import java.util.Optional;

/**
 * @Title：
 * @Author：wangchenggong
 * @Date 2020/9/22 6:47
 * @Description
 * @Version
 */
public enum LoanMethodEnum {

    AverageCapitalMethod("等额本金法"),
    AverageCapitalPlusInterestMethod("等额本息法");


    private String desc;

    LoanMethodEnum(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }


}
