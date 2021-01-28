package com.success.jike_chonggou;

import com.success.jike_chonggou.impl.ComputeExpression;
import com.success.jike_chonggou.impl.NumberExpression;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Title：后缀表达式解释器 重构后
 * @Author：wangchenggong
 * @Date 2021/1/27 16:32
 * @Description
 * @Version
 */
public class ExpressionInterpreterChonggou {
    /**
     * 双端队列,用来存储操作数
     */
    private Deque<String> numbers = new LinkedList<>();

    public String interpret(String expression){
        String[] elements = expression.split(" ");
        int length = elements.length;

        for (int i = 0; i < (length+1)/2; i++) {
            numbers.addLast(elements[i]);
        }

        for (int i = (length+1)/2; i < length; i++) {
            String operator = elements[i];
            boolean isValid = "+".equals(operator)
                            ||"-".equals(operator)
                            ||"*".equals(operator)
                            ||"/".equals(operator);
            if(!isValid){
                throw  new RuntimeException("Expression is invalid:"+expression);
            }
            NumberExpression number1 = new NumberExpression(numbers.pollFirst());
            NumberExpression number2 = new NumberExpression(numbers.pollFirst());

            ComputeExpression computeExpression = new ComputeExpression(number1,number2, operator);
            numbers.addFirst(String.valueOf(computeExpression.interpret()));
        }
        if(numbers.size() != 1){
            throw  new RuntimeException("Expression is invalid:"+expression);
        }
        return numbers.peekFirst();
    }


    public static void main(String[] args) {
        ExpressionInterpreterChonggou expressionInterpreter = new ExpressionInterpreterChonggou();
        String interpret = expressionInterpreter.interpret("8 3 2 4 - + *");
        System.out.println("解释结果为:"+interpret);

    }



}
