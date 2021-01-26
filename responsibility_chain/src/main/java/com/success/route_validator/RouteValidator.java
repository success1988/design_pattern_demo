package com.success.route_validator;

/**
 * @Title：路由校验器，用于校验候选通道是否符合要求
 * @Author：wangchenggong
 * @Date 2021/1/23 9:58
 * @Description
 * @Version
 */
public interface RouteValidator extends Comparable<RouteValidator>{

    /**
     * 获取路由校验器的优先级，(值越小，优先级越高)
     * @return 当前校验器的优先级
     */
    int getPriority();


    /**
     * 实现按优先级升序排列
     * @param o
     * @return
     */
    @Override
    default int compareTo(RouteValidator o){
        return getPriority() - o.getPriority();
    }
}
