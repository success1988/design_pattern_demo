package com.success.cainiao.impl;

import com.success.cainiao.Expression;

/**
 * @Title：
 * @Author：wangchenggong
 * @Date 2021/1/27 9:30
 * @Description
 * @Version
 */
public class AndExpression implements Expression {

    private Expression expression1;
    private Expression expression2;

    public AndExpression(Expression exp1,Expression exp2){
        this.expression1 = exp1;
        this.expression2 = exp2;
    }


    @Override
    public boolean interpret(String content) {
        return expression1.interpret(content) && expression2.interpret(content);
    }
}
