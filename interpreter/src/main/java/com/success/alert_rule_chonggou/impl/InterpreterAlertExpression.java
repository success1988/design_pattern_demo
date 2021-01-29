package com.success.alert_rule_chonggou.impl;

import com.success.alert_rule_chonggou.AlertExpression;

import java.util.Map;

/**
 * @Title：核心解释器
 * @Author：wangchenggong
 * @Date 2021/1/29 9:14
 * @Description
 * @Version
 */
public class InterpreterAlertExpression implements AlertExpression {


    private AlertExpression orAlertExpression;

    public InterpreterAlertExpression(String alertExpression){
        this.orAlertExpression = new OrAlertExpression(alertExpression);
    }


    @Override
    public boolean interpret(Map<String, Long> stateMap) {

        return orAlertExpression.interpret(stateMap);
    }
}
