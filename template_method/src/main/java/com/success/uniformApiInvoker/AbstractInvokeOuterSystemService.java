package com.success.uniformApiInvoker;

import com.success.uniformApiInvoker.req.OuterBaseRequest;
import com.success.uniformApiInvoker.res.OuterBaseResponse;
import com.success.uniformApiInvoker.util.HttpClientUtil;

/**
 * @Title：调用外部服务基类
 * @Author：wangchenggong
 * @Date 2020/9/25 18:42
 * @Description
 * @Version
 */
public abstract class AbstractInvokeOuterSystemService<T extends OuterBaseRequest,R extends OuterBaseResponse> implements InvokeOuterSystemService<T,R>{


    @Override
    public R request(T t) throws Exception {
        //1. 创建请求报文（不用的服务接口可能要进行的入参校验等，需要子类实现）
        String reqMessage = this.createMessage(t);
        //2. 发送请求报文（这个步骤可以共用）
        String respMessage = HttpClientUtil.doPostJson("http://url", reqMessage);
        //3. 将响应报文解析为响应信息对象（不用的服务接口需要响应不同的信息，需要子类实现）
        R resp = this.parseResponse(respMessage);
        return resp;
    }

    protected abstract String createMessage(T t);

    protected abstract R parseResponse(String responseMsg);

}
