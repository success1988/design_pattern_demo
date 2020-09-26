package com.success.uniformApiProvider;

import lombok.Getter;
import lombok.Setter;

/**
 * @Title：请求报文对象
 * @Author：wangchenggong
 * @Date 2020/9/26 7:42
 * @Description
 * @Version
 */
@Getter
@Setter
public class RequestMessage<T> {

    private String serviceName;

    private long reqTimestamp;

    private String sign;

    /**
     * 请求报文的请求体数据，其余为请求报文的请求头数据
     */
    private T data;

}
