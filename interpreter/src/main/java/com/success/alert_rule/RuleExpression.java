package com.success.alert_rule;

import java.util.Map;

/**
 * @Title：告警规则解释器接口
 * @Author：wangchenggong
 * @Date 2021/1/28 16:48
 * @Description
 * @Version
 */
public interface RuleExpression {

    /**
     *
     * @param stateMap
     * @return
     */
    public boolean interpret(Map<String,Long> stateMap);

}
