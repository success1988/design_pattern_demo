package com.success.uniformApiProvider.res;

import lombok.Getter;
import lombok.Setter;

/**
 * @Title：响应信息基类
 * @Author：wangchenggong
 * @Date 2020/9/26 10:51
 * @Description
 * @Version
 */
@Getter
@Setter
public class BaseResponse {

    private String requestNo;
    private Integer status;


}
