package com.success.alert_rule;

import com.success.alert_rule.impl.CoreRuleExpression;

import java.util.HashMap;
import java.util.Map;

/**
 * @Title：
 * @Author：wangchenggong
 * @Date 2021/1/28 17:48
 * @Description
 * @Version
 */
public class TestAlertRuleInterpreter {

    public static void main(String[] args) {

        String coreRuleExpression = "key1 > 100 && key2 < 30 || key3 < 100 || key4 == 88";

        Map<String,Long> stateMap = new HashMap<>();
        stateMap.put("key1", 101L);
        stateMap.put("key2", 10L);
        stateMap.put("key3", 200L);
        stateMap.put("key4", 66L);

        RuleExpression ruleExpression = new CoreRuleExpression(coreRuleExpression);
        boolean needAlertFlag = ruleExpression.interpret(stateMap);
        System.out.println("是否需要告警:" + needAlertFlag);
    }
}
