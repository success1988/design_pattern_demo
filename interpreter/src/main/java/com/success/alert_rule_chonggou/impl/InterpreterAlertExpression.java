package com.success.alert_rule_chonggou.impl;

import com.success.alert_rule_chonggou.AlertExpression;
import com.success.alert_rule_chonggou.AlertExpressionUtil;

import java.util.Map;

/**
 * @Title：核心解释器
 * @Author：wangchenggong
 * @Date 2021/1/29 9:14
 * @Description
 * @Version
 */
public class InterpreterAlertExpression implements AlertExpression {


    private AlertExpression alertExpression;

    public InterpreterAlertExpression(String alertExpressionStr){
        this.alertExpression = new OrAlertExpression(alertExpressionStr);
    }


    @Override
    public boolean interpret(Map<String, Long> stateMap) {
        return alertExpression.interpret(stateMap);
    }
}
