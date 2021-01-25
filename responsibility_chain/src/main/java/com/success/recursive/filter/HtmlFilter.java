package com.success.recursive.filter;

import com.success.recursive.*;
import com.success.recursive.chain.FilterChain;
import org.springframework.stereotype.Component;

/**
 * @Title：html过滤器
 * @Author：wangchenggong
 * @Date 2021/1/25 14:54
 * @Description
 * @Version
 */
@Component
public class HtmlFilter implements Filter {

    @Override
    public void doFilter(BaseReq baseReq, BaseRes baseRes, FilterChain filterChain) {
        //do something before
        baseReq.setReqContent(baseReq.getReqContent()
                .replaceAll("<","[")
                .replaceAll(">","]") +">>HtmlFilter");

        filterChain.doFilter(baseReq, baseRes);
        //do something after
        baseRes.setResContent(baseRes.getResContent()+">>HtmlFilter");
    }


    @Override
    public int getWeight() {
        return 0;
    }
}
