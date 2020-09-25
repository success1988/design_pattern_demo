package com.success.uniformApiInvoker;

import com.success.uniformApiInvoker.req.OuterBaseRequest;
import com.success.uniformApiInvoker.res.OuterBaseResponse;

/**
 * @Title：
 * @Author：wangchenggong
 * @Date 2020/9/25 18:42
 * @Description
 * @Version
 */
public class AbstractInvokeOuterSystemService<T extends OuterBaseRequest,R extends OuterBaseResponse> implements InvokeOuterSystemService<T,R>{


    @Override
    public R request(T o) throws Exception {
        return null;
    }


}
