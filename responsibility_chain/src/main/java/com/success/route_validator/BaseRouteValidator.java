package com.success.route_validator;

/**
 * @Title：路由校验器子接口，具体的校验器实现该接口
 * @Author：wangchenggong
 * @Date 2021/1/25 8:56
 * @Description
 * @Version
 */
public interface BaseRouteValidator extends RouteValidator,Comparable<BaseRouteValidator>{

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
    default int compareTo(BaseRouteValidator o){
        return getPriority() - o.getPriority();
    }
}
