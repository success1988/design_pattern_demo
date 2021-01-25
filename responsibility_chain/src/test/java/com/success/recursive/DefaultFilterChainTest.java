package com.success.recursive;

import com.success.recursive.chain.DefaultFilterChain;
import com.success.recursive.chain.FilterChain;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Title：过滤器链的单元测试
 * @Author：wangchenggong
 * @Date 2021/1/25 15:38
 * @Description
 * @Version
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DefaultFilterChainTest {

    @Autowired
    private FilterChain filterChain;

    @Test
    public void testDoFilter() {
        for (int i = 0; i < 2; i++) {
            BaseReq baseReq = new BaseReq();
            baseReq.setReqContent("<div>你好，你真牛逼！</div>");

            BaseRes baseRes = new BaseRes();
            baseRes.setResContent("response");

            filterChain.doFilter(baseReq, baseRes);

            System.out.println("请求报文:"+baseReq.getReqContent());
            System.out.println("响应报文:"+baseRes.getResContent());
        }

    }
}