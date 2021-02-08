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
public class OrAlertExpression implements AlertExpression {

    private List<AlertExpression> alertExpressionList = new ArrayList<>();

    public OrAlertExpression(String alertExpressionStr){
        if(AlertExpressionUtil.isKuoHaoExpression(alertExpressionStr)){
            alertExpressionList.add(new KuoHaoAlertExpression(alertExpressionStr));
        }else{
            String[] expressionArr = AlertExpressionUtil.splitByOuterOperator(alertExpressionStr.trim(), "||");
            for (int i = 0; i < expressionArr.length; i++) {
                String currentExpressionStr = expressionArr[i].trim();
                if(AlertExpressionUtil.isKuoHaoExpression(currentExpressionStr)){
                    alertExpressionList.add(new KuoHaoAlertExpression(currentExpressionStr));
                }else{
                    //
                    alertExpressionList.add(new AndAlertExpression(currentExpressionStr));
                }
            }
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
