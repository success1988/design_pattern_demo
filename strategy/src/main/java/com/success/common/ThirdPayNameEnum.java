package com.success.common;

import java.util.Arrays;
import java.util.Optional;

/**
 * @Title：三方支付的渠道枚举
 * @Author：wangchenggong
 * @Date 2020/9/21 17:56
 * @Description
 * @Version
 */
public enum  ThirdPayNameEnum {

    ALIPAY("alipay","支付宝支付"),
    WXPAY("wxpay","微信支付");


    /**
     * 名称
     */
    private String name;
    /**
     * 描述
     */
    private String desc;

    ThirdPayNameEnum(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }


    public static ThirdPayNameEnum getEnumByName(String name) {
        Optional<ThirdPayNameEnum> optional = Arrays.stream(ThirdPayNameEnum.values()).filter(e -> e.name.equals(name)).findFirst();
        if(optional.isPresent()){
            return optional.get();
        }
        throw new IllegalArgumentException("No enum name '" + name + "' in " + ThirdPayNameEnum.class);
    }
}
