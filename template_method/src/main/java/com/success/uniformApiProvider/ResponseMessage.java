package com.success.uniformApiProvider;

import lombok.Getter;
import lombok.Setter;

/**
 * @Title：响应报文对象
 * @Author：wangchenggong
 * @Date 2020/9/26 10:06
 * @Description
 * @Version
 */
@Getter
@Setter
public class ResponseMessage<R> {

    private String code;
    private String msg;
    /**
     * 响应报文的响应体数据（当发生异常时，响应体数据会为空），其余为响应报文的响应头数据
     */
    private R data;

}
