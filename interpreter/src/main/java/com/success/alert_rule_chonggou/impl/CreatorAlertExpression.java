package com.success.alert_rule_chonggou.impl;

import com.success.alert_rule_chonggou.AlertExpression;

import java.util.Map;

/**
 * @Title：
 * @Author：wangchenggong
 * @Date 2021/1/29 9:14
 * @Description
 * @Version
 */
public class CreatorAlertExpression implements AlertExpression {


    private AlertExpression orAlertExpression;

    public CreatorAlertExpression(String alertExpression){
        this.orAlertExpression = new OrAlertExpression(alertExpression);
    }


    @Override
    public boolean interpret(Map<String, Long> stateMap) {

        return orAlertExpression.interpret(stateMap);
    }
}
