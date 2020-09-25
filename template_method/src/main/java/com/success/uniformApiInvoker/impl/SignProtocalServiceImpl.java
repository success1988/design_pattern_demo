package com.success.uniformApiInvoker.impl;

import com.alibaba.fastjson.JSON;
import com.success.uniformApiInvoker.AbstractInvokeOuterSystemService;
import com.success.uniformApiInvoker.req.SignProtocalRequest;
import com.success.uniformApiInvoker.res.SignProtocalResponse;
import org.springframework.stereotype.Service;

/**
 * @Title：签约服务接口
 * @Author：wangchenggong
 * @Date 2020/9/26 6:12
 * @Description
 * @Version
 */
@Service
public class SignProtocalServiceImpl extends AbstractInvokeOuterSystemService<SignProtocalRequest, SignProtocalResponse> {

    @Override
    protected String createMessage(SignProtocalRequest signProtocalRequest) {
        //这里可以做一些入参校验，或其他逻辑处理

        return JSON.toJSONString(signProtocalRequest);
    }

    @Override
    protected SignProtocalResponse parseResponse(String responseMsg) {
        //这里可以做一些解析工作，或其他逻辑处理
        return JSON.parseObject(responseMsg, SignProtocalResponse.class);
    }
}
