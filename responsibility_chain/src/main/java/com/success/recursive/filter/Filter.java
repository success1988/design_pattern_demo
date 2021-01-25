package com.success.recursive.filter;


import com.success.recursive.BaseReq;
import com.success.recursive.BaseRes;
import com.success.recursive.chain.FilterChain;

/**
 * @Title：过滤器接口
 * @Author：wangchenggong
 * @Date 2021/1/25 13:48
 * @Description
 * @Version
 */
public interface Filter {

    /**
     * 执行过滤逻辑
     * @param baseReq
     * @param baseRes
     * @param baseRes
     * @return
     */
    void doFilter(BaseReq baseReq, BaseRes baseRes, FilterChain filterChain);


    /**
     * 获取权重
     * @return
     */
    int getWeight();

}
