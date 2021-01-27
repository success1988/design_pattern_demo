package com.success.jike;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Title：后缀表达式解释器
 * @Author：wangchenggong
 * @Date 2021/1/27 16:32
 * @Description
 * @Version
 */
public class ExpressionInterpreter {
    /**
     * 双端队列,用来存储操作数
     */
    private Deque<Long> numbers = new LinkedList<>();

    public long interpret(String expression){
        String[] elements = expression.split(" ");
        int length = elements.length;

        for (int i = 0; i < (length+1)/2; i++) {
            numbers.addLast(Long.parseLong(elements[i]));
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
            long number1 = numbers.pollFirst();
            long number2 = numbers.pollFirst();
            long result = 0;
            if("+".equals(operator)){
                result = number1 + number2;
            }else if("-".equals(operator)){
                result = number1 - number2;
            }else if("*".equals(operator)){
                result = number1 * number2;
            }else if("/".equals(operator)){
                result = number1 / number2;
            }
            numbers.addFirst(result);
        }
        if(numbers.size() != 1){
            throw  new RuntimeException("Expression is invalid:"+expression);
        }
        return numbers.peekFirst();
    }


    public static void main(String[] args) {
        ExpressionInterpreter expressionInterpreter = new ExpressionInterpreter();
        long interpret = expressionInterpreter.interpret("8 3 2 4 - + *");
        System.out.println("解释结果为:"+interpret);

    }



}
