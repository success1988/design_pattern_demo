package com.success.alert_rule_chonggou;

import java.util.Map;

/**
 * @Title：
 * @Author：wangchenggong
 * @Date 2021/1/28 22:33
 * @Description
 * @Version
 */
public interface AlertExpression {
    /**
     *
     * @param stateMap
     * @return
     */
    public boolean interpret(Map<String,Long> stateMap);
}
