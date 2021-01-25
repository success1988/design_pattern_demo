package com.success.recursive.chain;


import com.success.recursive.BaseReq;
import com.success.recursive.BaseRes;

/**
 * @Title：过滤器链接口
 * @Author：wangchenggong
 * @Date 2021/1/25 13:48
 * @Description
 * @Version
 */
public interface FilterChain {

    /**
     * 执行过滤器链的过滤逻辑
     * @param baseReq
     * @param baseRes
     * @return
     */
    void doFilter(BaseReq baseReq, BaseRes baseRes);
}
