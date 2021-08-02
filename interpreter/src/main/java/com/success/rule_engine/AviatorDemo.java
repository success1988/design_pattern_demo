package com.success.rule_engine;

import com.googlecode.aviator.AviatorEvaluator;

import java.util.HashMap;
import java.util.Map;

/**
 * @Title
 * @Author wangwenliang
 * @Date 2021/7/6
 * @Description
 */
public class AviatorDemo {

    public static void main(String[] args) {
//        String expression = "a + b + c";
        String expression = " (a < b && c<=3)";

        Map<String, Object> params = new HashMap<>();
        params.put("a", 1);
        params.put("b", 2);
        params.put("c", 3);

//        long result = (long) AviatorEvaluator.execute(expression, params);
        Object result = AviatorEvaluator.execute(expression, params);

        System.out.printf("result : " + result);
    }
}
