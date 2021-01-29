package com.success.alert_rule_chonggou.impl;

import com.success.alert_rule_chonggou.AlertExpression;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Title：与运算
 * @Author：wangchenggong
 * @Date 2021/1/28 22:44
 * @Description
 * @Version
 */
public class OrAlertExpression implements AlertExpression {

    private List<AlertExpression> alertExpressionList = new ArrayList<>();

    public OrAlertExpression(String andExpression){
        String[] arr = andExpression.split("\\|\\|");
        AlertExpression alertExpression = null;

        for (int i = 0; i < arr.length; i++) {
            String compareExpression = arr[i];
            if(compareExpression.contains("&&")){
                alertExpressionList.add(new AndAlertExpression(compareExpression));
            }else{
                String[] elements = compareExpression.trim().split("\\s+");
                String compareOperation = elements[1];

                if(compareOperation.equals(">")){
                    alertExpression = new GreaterAlertExpression(compareExpression);
                }else if(compareOperation.equals("<")){
                    alertExpression = new LessAlertExpression(compareExpression);
                }else if(compareOperation.equals("==")){
                    alertExpression = new EqualAlertExpression(compareExpression);
                }else {
                    throw  new RuntimeException("表达式不合法:"+andExpression);
                }
            }
            alertExpressionList.add(alertExpression);
        }
    }

    @Override
    public boolean interpret(Map<String, Long> stateMap) {
        for (AlertExpression alertExpression: alertExpressionList) {
            if(alertExpression.interpret(stateMap)){
                return true;
            }
        }
        return false;
    }
}
