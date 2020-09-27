package com.success.notice.vo;

import lombok.Data;

/**
 * @Title：通知的消息信息
 * @Author：wangchenggong
 * @Date 2020/9/27 14:01
 * @Description
 * @Version
 */
@Data
public class NoticeMessage {

    /**
     * 系统标识
     */
    private String systemCode;

    /**
     * 服务名称，表示的是向其他系统通知的是哪个服务的业务处理结果
     */
    private String serviceName;

    /**
     * 通知消息ID，通常为业务流水号或订单号
     */
    private String uniqueNo;



}
