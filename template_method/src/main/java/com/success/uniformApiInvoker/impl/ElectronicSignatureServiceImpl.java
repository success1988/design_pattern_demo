package com.success.uniformApiInvoker.impl;

import com.alibaba.fastjson.JSON;
import com.success.uniformApiInvoker.AbstractInvokeOuterSystemService;
import com.success.uniformApiInvoker.req.ElectronicSignatureRequest;
import com.success.uniformApiInvoker.res.ElectronicSignatureResponse;
import org.springframework.stereotype.Service;

/**
 * @Title：电子签章服务
 * @Author：wangchenggong
 * @Date 2020/9/26 6:23
 * @Description
 * @Version
 */
@Service
public class ElectronicSignatureServiceImpl extends AbstractInvokeOuterSystemService<ElectronicSignatureRequest, ElectronicSignatureResponse> {


    @Override
    protected String createMessage(ElectronicSignatureRequest electronicSignatureRequest) {
        //这里可以做一些入参校验，或其他逻辑处理

        return JSON.toJSONString(electronicSignatureRequest);
    }

    @Override
    protected ElectronicSignatureResponse parseResponse(String responseMsg) {
        //这里可以做一些解析工作，或其他逻辑处理
        return JSON.parseObject(responseMsg, ElectronicSignatureResponse.class);
    }
}
