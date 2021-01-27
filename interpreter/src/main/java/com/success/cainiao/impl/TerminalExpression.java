package com.success.cainiao.impl;

import com.success.cainiao.Expression;

/**
 * @Title：
 * @Author：wangchenggong
 * @Date 2021/1/27 9:27
 * @Description
 * @Version
 */
public class TerminalExpression implements Expression {
    private String data;

    public TerminalExpression(String data){
        this.data = data;
    }

    @Override
    public boolean interpret(String content) {
        if(content.contains(data)){
            return true;
        }
        return false;
    }


}
