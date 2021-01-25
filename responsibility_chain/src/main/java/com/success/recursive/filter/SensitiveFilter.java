package com.success.recursive.filter;

import com.success.recursive.*;
import com.success.recursive.chain.FilterChain;
import org.springframework.stereotype.Component;

/**
 * @Title：敏感词过滤器
 * @Author：wangchenggong
 * @Date 2021/1/25 14:54
 * @Description
 * @Version
 */
@Component
public class SensitiveFilter implements Filter {

    @Override
    public void doFilter(BaseReq baseReq, BaseRes baseRes, FilterChain filterChain) {
        //do something before
        baseReq.setReqContent(baseReq.getReqContent()
                .replaceAll("牛逼","牛X")+">>SensitiveFilter");
        filterChain.doFilter(baseReq, baseRes);
        //do something after
        baseRes.setResContent(baseRes.getResContent()+">>SensitiveFilter");
    }

    @Override
    public int getWeight() {
        return 1;
    }
}
