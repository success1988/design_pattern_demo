package com.success.route_validator;

/**
 * @Title：支付路由校验器
 * @Author：wangchenggong
 * @Date 2021/1/25 8:56
 * @Description
 * @Version
 */
public interface PayRouteValidator extends RouteValidator{
    /**
     * 校验候选通道是否符合要求
     * @param channel 候选通道
     * @return 是否通过校验 ，不通过校验则返回false
     */
    boolean validate(Channel channel);
}
