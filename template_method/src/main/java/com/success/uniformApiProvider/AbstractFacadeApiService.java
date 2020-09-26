package com.success.uniformApiProvider;

import com.alibaba.fastjson.JSONObject;
import com.success.uniformApiProvider.req.BaseRequest;

/**
 * @Title：对外提供的统一接口服务基类
 * @Author：wangchenggong
 * @Date 2020/9/26 8:12
 * @Description   JSONObject是用来明确FacadeApiService<T>中的泛型类型，而AbstractFacadeApiService<T extends BaseRequest,R>中的泛型类型需要子类明确
 * @Version
 */
public abstract class AbstractFacadeApiService<T extends BaseRequest,R> implements FacadeApiService<JSONObject>{


    /**
     *
     * @param requestMessage 请求报文对象（这个请求报文对象需要在Controller中对请求json报文做初步的解析，才可以得到）
     * @return
     */
    @Override
    public String handle(RequestMessage<JSONObject> requestMessage) {
        //这里可以做一些入参校验、验签等，主要针对请求头信息

        //1. 解析请求体信息
        T t = this.parseJSONObject(requestMessage.getData());
        //2. 执行业务逻辑（不同的服务接口处理逻辑不同，所以）
        ResponseMessage<R> responseMessage = this.doHandle(t);
        //3.将响应信息序列化为json串（此步骤可以共用）
        String responseMsg = JSONObject.toJSONString(responseMessage);
        return responseMsg;
    }

    protected abstract ResponseMessage<R> doHandle(T req);

    protected abstract T parseJSONObject(JSONObject jsonObject);


}
