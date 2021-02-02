package com.success.alert_rule_chonggou;

import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * @Title：
 * @Author：wangchenggong
 * @Date 2021/2/1 22:53
 * @Description
 * @Version
 */
public class AlertExpressionUtil {

    public static boolean isKuoHaoExpression(String alertExpression){
        alertExpression = alertExpression.trim();
        if(alertExpression.startsWith("(") && alertExpression.endsWith(")")){
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        String expression = "key5 == 8 || ( key1 > 100 && ( key2 < 30 || key3 < 100 ) ) && key6 > 90 || key4 == 88";

        String[] resultArr = splitByOuterOperator(expression, "||");
        System.out.println(Arrays.toString(resultArr));
    }
    public static String[] splitByOuterOperator(String expression, String operator) {
        String[] elements = expression.trim().split("\\s+");
        //"key5 == 8 || ( key1 > 100 && ( key2 < 30 || key3 < 100 ) ) && key6 > 90 || key4 == 88"

        //使用栈来统计出 外层() 的索引范围
        Stack<String> elementStack = new Stack<>();

        List<Integer> validOperatorIndex = new ArrayList<>();

        boolean validSwitch = true;
        int length = elements.length;
        for (int i = 0; i <length; i++) {
            String element = elements[i];
            if(element.equals(operator) && validSwitch){
                validOperatorIndex.add(i);
                continue;
            }

            if(element.equals("(")){
                //遇到左括号，validSwitch = false,同时压入栈中
                elementStack.push(element);
                validSwitch = false;
                continue;
            }else if(element.equals(")")){
                //遇到右括号，就把栈顶的左括号弹出
                elementStack.pop();

                //如果栈size为空,validSwitch = true
                if(elementStack.size() == 0){
                    validSwitch = true;
                }
            }

        }

        //筛选出 外层的operator 的 索引位置

        //根据外层的operator 进行字符串截取

        if(CollectionUtils.isEmpty(validOperatorIndex)){
            return new String[]{expression};
        }else{
            List<String> resultList = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < length; i++) {
                //当遇到外层分隔符时
                if(validOperatorIndex.contains(i)){
                    resultList.add(sb.toString().trim());
                    sb = new StringBuilder();
                }else{
                    String element = elements[i];
                    sb.append(element).append(" ");
                }
            }
            resultList.add(sb.toString().trim());
            return resultList.toArray(new String[0]);
        }
    }


}
