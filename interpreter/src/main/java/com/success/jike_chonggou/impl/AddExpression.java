package com.success.jike_chonggou.impl;

import com.success.jike_chonggou.IExpression;

/**
 * @Title：加法表达式
 * @Author：wangchenggong
 * @Date 2021/1/28 9:27
 * @Description
 * @Version
 */
public class AddExpression implements IExpression {

    private NumberExpression number1;
    private NumberExpression number2;

    public AddExpression(NumberExpression number1, NumberExpression number2){
        this.number1 = number1;
        this.number2 = number2;
    }

    @Override
    public long interpret() {
        return number1.interpret() + number2.interpret();
    }
}
