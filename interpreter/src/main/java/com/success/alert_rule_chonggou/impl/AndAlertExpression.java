package com.success.alert_rule_chonggou.impl;

import com.success.alert_rule_chonggou.AlertExpression;
import com.success.alert_rule_chonggou.AlertExpressionUtil;
import lombok.Data;

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
@Data
public class AndAlertExpression implements AlertExpression {

    private List<AlertExpression> alertExpressionList = new ArrayList<>();

    public AndAlertExpression(String expressionStr){

        if(AlertExpressionUtil.isKuoHaoExpression(expressionStr)){
            alertExpressionList.add(new KuoHaoAlertExpression(expressionStr));
        }else{
            String[] expressionArr = AlertExpressionUtil.splitByOuterOperator(expressionStr.trim(), "&&");
            AlertExpression alertExpression = null;
            for (int i = 0; i < expressionArr.length; i++) {
                String currentExpressionStr = expressionArr[i].trim();
                if(AlertExpressionUtil.isKuoHaoExpression(currentExpressionStr)){
                    alertExpressionList.add(new KuoHaoAlertExpression(currentExpressionStr));
                }else{
                    String[] elements = currentExpressionStr.trim().split("\\s+");
                    String compareOperation = elements[1];

                    if(compareOperation.equals(">")){
                        alertExpression = new GreaterAlertExpression(currentExpressionStr);
                    }else if(compareOperation.equals("<")){
                        alertExpression = new LessAlertExpression(currentExpressionStr);
                    }else if(compareOperation.equals("==")){
                        alertExpression = new EqualAlertExpression(currentExpressionStr);
                    }else {
                        throw  new RuntimeException("表达式不合法:"+expressionStr);
                    }
                    alertExpressionList.add(alertExpression);
                }
            }

        }

    }

    @Override
    public boolean interpret(Map<String, Long> stateMap) {
        for (AlertExpression alertExpression: alertExpressionList) {
            if(!alertExpression.interpret(stateMap)){
                return false;
            }
        }
        return true;
    }
}
