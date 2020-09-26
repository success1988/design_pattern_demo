package com.success.uniformApiProvider;



/**
 * @Title：对外提供的统一接口服务
 * @Author：wangchenggong
 * @Date 2020/9/26 7:39
 * @Description
 * @Version
 */
public interface FacadeApiService<T> {

    /**
     * 处理请求
     * @param requestMessage 请求报文对象
     * @return 响应报文
     */
    public String handle(RequestMessage<T> requestMessage);


}
