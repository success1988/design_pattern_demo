package com.success.cainiao;

import com.success.cainiao.impl.AndExpression;
import com.success.cainiao.impl.OrExpression;
import com.success.cainiao.impl.TerminalExpression;

/**
 * @Title：测试用例
 * @Author：wangchenggong
 * @Date 2021/1/27 9:34
 * @Description
 * @Version
 */
public class InterpreterPatternDemo {


    public static Expression getMaleExpression(){
        Expression robert = new TerminalExpression("Robert");
        Expression john = new TerminalExpression("John");
        return new OrExpression(robert, john);
    }

    public static Expression getFemaleAndMarriageExpression(){
        Expression female = new TerminalExpression("Marry");
        Expression marriage = new TerminalExpression("Marry");
        return new AndExpression(female, marriage);
    }

    public static void main(String[] args) {

        String isMaleStr = "John is male?";
        Expression maleExpression = getMaleExpression();
        boolean isMaleResult = maleExpression.interpret(isMaleStr);
        System.out.println(isMaleStr+">>>>>"+isMaleResult);


        String isFemaleAndMarriageStr = "Marry is female and marriage?";
        Expression isFemaleAndMarriageExpression = getFemaleAndMarriageExpression();
        boolean isFemaleAndMarriageResult = isFemaleAndMarriageExpression.interpret(isFemaleAndMarriageStr);
        System.out.println(isFemaleAndMarriageStr+">>>>>"+isFemaleAndMarriageResult);

        String isAllTrue = isMaleStr + "and "+ isFemaleAndMarriageStr;
        Expression isAllTrueExpression = new AndExpression(maleExpression, isFemaleAndMarriageExpression);
        boolean result = isAllTrueExpression.interpret(isAllTrue);
        System.out.println(result);
    }
}
