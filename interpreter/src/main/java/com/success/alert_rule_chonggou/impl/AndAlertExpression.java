package com.success.alert_rule_chonggou.impl;

import com.success.alert_rule_chonggou.AlertExpression;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Title：
 * @Author：wangchenggong
 * @Date 2021/1/28 22:44
 * @Description
 * @Version
 */
public class AndAlertExpression implements AlertExpression {

    private List<AlertExpression> alertExpressionList = new ArrayList<>();

    public AndAlertExpression(String andExpression){
        String[] split = andExpression.split("&&");


    }

    @Override
    public boolean interpret(Map<String, Long> stateMap) {
        return false;
    }
}
