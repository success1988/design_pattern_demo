package com.success.uniformApiInvoker;

/**
 * @Title：调用外部其他系统的统一接口服务
 * @Author：wangchenggong
 * @Date 2020/9/25 16:25
 * @Description
 * @Version
 */
public interface InvokeOuterSystemService<T,R> {

    /**
     * 请求外部接口服务
     * @param t
     * @return
     * @throws Exception
     */
    R request(T t) throws Exception;
}
