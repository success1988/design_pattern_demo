package com.success.common;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Title：
 * @Author：wangchenggong
 * @Date 2020/9/22 6:45
 * @Description
 * @Version
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface LoanComputeMethod {

    LoanMethodEnum value();
}
