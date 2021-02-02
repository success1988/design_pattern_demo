package com.success.alert_rule_chonggou.impl;

import com.success.alert_rule_chonggou.AlertExpression;

import java.util.Map;

/**
 * @Title：括号表达式，开头和结尾分别为“(”和“)”
 * @Author：wangchenggong
 * @Date 2021/2/1 22:11
 * @Description
 * @Version
 */
public class KuoHaoAlertExpression implements AlertExpression {

    private AlertExpression alertExpression;

    public KuoHaoAlertExpression(String alertExpressionStr){
        String trimAlertExpressionStr = alertExpressionStr.trim();
        String orAlertExpressionStr = trimAlertExpressionStr.substring(1, trimAlertExpressionStr.length() - 1).trim();
        this.alertExpression = new OrAlertExpression(orAlertExpressionStr);
    }

    @Override
    public boolean interpret(Map<String, Long> stateMap) {
        return alertExpression.interpret(stateMap);
    }
}
