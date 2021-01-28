package com.success.jike_chonggou.impl;

import com.success.jike_chonggou.IExpression;

/**
 * @Title：减法表达式
 * @Author：wangchenggong
 * @Date 2021/1/28 9:27
 * @Description
 * @Version
 */
public class SubtractExpression implements IExpression {

    private IExpression number1;
    private IExpression number2;

    public SubtractExpression(IExpression number1, IExpression number2){
        this.number1 = number1;
        this.number2 = number2;
    }

    @Override
    public long interpret() {
        return number1.interpret() - number2.interpret();
    }
}
