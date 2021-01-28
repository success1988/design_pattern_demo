package com.success.jike_chonggou.impl;

import com.success.jike_chonggou.IExpression;

/**
 * @Title：
 * @Author：wangchenggong
 * @Date 2021/1/28 9:40
 * @Description
 * @Version
 */
public class ComputeExpression implements IExpression {

    private IExpression computeExpression;

    public ComputeExpression(NumberExpression number1, NumberExpression number2,String computeStr){

        switch (computeStr){
            case "+" :
                this.computeExpression = new AddExpression(number1,number2);
                break;
            case "-" :
                this.computeExpression = new SubstractExpression(number1,number2);
                break;
            case "*" :
                this.computeExpression = new MultipleExpression(number1,number2);
                break;
            case "/" :
                this.computeExpression = new DivideExpression(number1,number2);
                break;
        }
        //TODO 异常处理

    }

    @Override
    public long interpret() {
        return this.computeExpression.interpret();
    }
}
