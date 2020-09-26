package com.success.uniformApiProvider.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.success.uniformApiProvider.AbstractFacadeApiService;
import com.success.uniformApiProvider.ResponseMessage;
import com.success.uniformApiProvider.req.BindCardRequest;
import com.success.uniformApiProvider.res.BindCardResponse;
import org.springframework.stereotype.Service;

/**
 * @Title：绑卡服务
 * @Author：wangchenggong
 * @Date 2020/9/26 10:49
 * @Description
 * @Version
 */
@Service
public class BindCardServiceImpl extends AbstractFacadeApiService<BindCardRequest, BindCardResponse> {


    @Override
    protected ResponseMessage<BindCardResponse> doHandle(BindCardRequest req) {
        ResponseMessage<BindCardResponse> responseMessage = new ResponseMessage<>();
        responseMessage.setCode("0");

        BindCardResponse bindCardResponse = new BindCardResponse();
        bindCardResponse.setRequestNo(req.getRequestNo());
        responseMessage.setData(bindCardResponse);
        System.out.println(">>处理绑卡业务,请求信息为:"+ JSON.toJSONString(req));

        return responseMessage;
    }

    @Override
    protected BindCardRequest parseJSONObject(JSONObject jsonObject) {
        return JSONObject.toJavaObject(jsonObject, BindCardRequest.class);
    }
}
