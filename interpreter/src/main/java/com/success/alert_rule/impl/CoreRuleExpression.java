package com.success.alert_rule.impl;

import com.success.alert_rule.RuleExpression;

import java.util.*;

/**
 * @Title：
 * @Author：wangchenggong
 * @Date 2021/1/28 17:42
 * @Description
 * 为了简化讲解和代码实现，我们假设自定义的告警规则只包含“||、&&、>、<、==”这五个运算符，
 * 其中，“>、<、==”运算符的优先级高于“||、&&”运算符
 * “&&”运算符优先级高于“||”。
 * 在表达式中，任意元素之间需要通过空格来分隔。
 * @Version
 */
public class CoreRuleExpression implements RuleExpression {
    private String originAlertRuleExpression;
    //用于比较运算结果的双端队列
    private Deque<Boolean> compareResults = new LinkedList<>();
    //用于存储逻辑运算符的双端队列
    private Deque<String> logicalOperations = new LinkedList<>();

    //key1 > 100 && key2 < 30 || key3 < 100 || key4 == 88
    public CoreRuleExpression(String alertRuleExpression){
        this.originAlertRuleExpression = alertRuleExpression;
    }

    @Override
    public boolean interpret(Map<String, Long> stateMap) {
        //1. 变量替换
        String alertRuleExpressionDeal = replaceValueForOriginAlertRuleExpression(stateMap, originAlertRuleExpression);

        //2.拆解为多个比较表达式
        String[] expressionArr = alertRuleExpressionDeal.split(" ");
        int compareExpressionNum = (expressionArr.length+1)/4;

        boolean needYuFlag = false;
        for(int i=0; i<compareExpressionNum; i++){
            long number1 = Long.valueOf(expressionArr[4*i]);
            String compareOperation = expressionArr[4*i+1];
            long number2 =Long.valueOf(expressionArr[4*i+2]);
            boolean compareResult = false;
            if(compareOperation.equals(">")){
                compareResult = number1 > number2;
            }else if(compareOperation.equals("<")){
                compareResult = number1 < number2;
            }else if(compareOperation.equals("==")){
                compareResult = number1 == number2;
            }else{
                throw  new RuntimeException("表达式不合法:"+originAlertRuleExpression);
            }


            if(needYuFlag){
                Boolean prevResult = compareResults.pollLast();
                Boolean currentYuResult = compareResult && prevResult;
                compareResults.addLast(currentYuResult);
            }else{
                compareResults.addLast(compareResult);
            }

            if(i < compareExpressionNum-1){
                String logicalOperation = expressionArr[4*i+3];
                if(logicalOperation.equals("&&")){
                    needYuFlag = true;
                }else{
                    needYuFlag = false;
                    logicalOperations.addLast(logicalOperation);
                }
            }

        }

        //3.处理最后
        while(compareResults.size() > 1){
            Boolean value1 = compareResults.pollFirst();
            Boolean value2 = compareResults.pollFirst();

            String logicalOperation = logicalOperations.pollFirst();
            if(logicalOperation.equals("||")){
                Boolean currentValue = value1 || value2;
                compareResults.addFirst(currentValue);
            }else{
                throw  new RuntimeException("表达式不合法:"+originAlertRuleExpression);
            }
        }

        return compareResults.pollFirst();
    }

    /**
     * 替换变量
     * @param stateMap
     * @param expression
     * @return
     */
    private String replaceValueForOriginAlertRuleExpression(Map<String, Long> stateMap, String expression) {
        if(stateMap != null && !stateMap.isEmpty()){
            Iterator<Map.Entry<String, Long>> iterator = stateMap.entrySet().iterator();
            while(iterator.hasNext()){
                Map.Entry<String, Long> entry = iterator.next();
                expression = expression.replace(entry.getKey(), String.valueOf(entry.getValue()));
            }
        }
        return expression;
    }


}
