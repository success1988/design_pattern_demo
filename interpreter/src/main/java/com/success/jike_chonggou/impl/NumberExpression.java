package com.success.jike_chonggou.impl;

import com.success.jike_chonggou.IExpression;

/**
 * 操作数
 * @Author：wangchenggong
 * @Date 2021/1/28 9:25
 * @Description
 * @Version
 */
public class NumberExpression implements IExpression {

    private long number;

    public NumberExpression(long number){
        this.number = number;
    }

    public NumberExpression(String numberStr){
        //TODO: 转换异常的处理
        this.number = Long.valueOf(numberStr);
    }

    @Override
    public long interpret() {
        return this.number;
    }
}
