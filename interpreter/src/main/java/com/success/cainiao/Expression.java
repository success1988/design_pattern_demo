package com.success.cainiao;

/**
 * @Title：表达式接口
 * @Author：wangchenggong
 * @Date 2021/1/27 9:13
 * @Description
 * @Version
 */
public interface Expression {

    /**
     * 封装解析算法
     * @param content 要解析的表达式
     * @return 解析结果
     */
    public boolean interpret(String content);
}
