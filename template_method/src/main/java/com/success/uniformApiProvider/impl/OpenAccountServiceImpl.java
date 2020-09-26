package com.success.uniformApiProvider.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.success.uniformApiProvider.AbstractFacadeApiService;
import com.success.uniformApiProvider.ResponseMessage;
import com.success.uniformApiProvider.req.OpenAccountRequest;
import com.success.uniformApiProvider.res.OpenAccountResponse;
import org.springframework.stereotype.Service;

/**
 * @Title：开户服务
 * @Author：wangchenggong
 * @Date 2020/9/26 11:00
 * @Description
 * @Version
 */
@Service
public class OpenAccountServiceImpl extends AbstractFacadeApiService<OpenAccountRequest, OpenAccountResponse> {
    @Override
    protected ResponseMessage<OpenAccountResponse> doHandle(OpenAccountRequest req) {
        ResponseMessage<OpenAccountResponse> responseMessage = new ResponseMessage<>();
        responseMessage.setCode("0");

        OpenAccountResponse openAccountResponse = new OpenAccountResponse();
        openAccountResponse.setRequestNo(req.getRequestNo());
        responseMessage.setData(openAccountResponse);
        System.out.println(">>处理开户业务,请求信息为:"+ JSON.toJSONString(req));
        return responseMessage;
    }

    @Override
    protected OpenAccountRequest parseJSONObject(JSONObject jsonObject) {
        return JSONObject.toJavaObject(jsonObject, OpenAccountRequest.class);
    }
}
