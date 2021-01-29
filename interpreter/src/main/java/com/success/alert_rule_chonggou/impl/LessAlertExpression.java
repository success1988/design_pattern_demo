package com.success.alert_rule_chonggou.impl;

import com.success.alert_rule_chonggou.AlertExpression;

import java.util.Map;

/**
 * @Title：
 * @Author：wangchenggong
 * @Date 2021/1/28 22:34
 * @Description
 * @Version
 */
public class LessAlertExpression implements AlertExpression {

    private String key;
    private long limitValue;


    public LessAlertExpression(String greaterExpression){
        String[] arr = greaterExpression.trim().split("\\s+");
        this.key = arr[0];
        this.limitValue = Long.valueOf(arr[2]);
    }


    @Override
    public boolean interpret(Map<String, Long> stateMap) {
        if(!stateMap.containsKey(key)){
            return false;
        }
        long currentVal = stateMap.get(key);
        return currentVal < limitValue;
    }
}
