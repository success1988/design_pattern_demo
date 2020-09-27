package com.success.notice.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.success.notice.AbstractNoticeService;
import com.success.notice.vo.NoticeMessage;
import com.success.notice.vo.NoticeResult;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

/**
 * @Title：充值结果通知
 * @Author：wangchenggong
 * @Date 2020/9/27 14:40
 * @Description
 * @Version
 */
@Service
public class RechargeNoticeServiceImpl extends AbstractNoticeService {
    @Override
    protected void updateNoticeStatus(NoticeResult noticeResult, NoticeMessage noticeMessage) {
        System.out.println(">>>>>RechargeNoticeServiceImpl 执行通知状态更新,消息信息:"+ JSON.toJSONString(noticeMessage)+",通知结果为:"+JSON.toJSONString(noticeResult));
    }

    @Override
    protected String buildNoticeContent(String uniqueNo) {
        System.out.println(">>>>>RechargeNoticeServiceImpl 构建通知内容,uniqueNo:"+ uniqueNo);
        JSONObject data = new JSONObject();
        data.put("serviceName","RechargeNoticeService");
        data.put("requestNo",uniqueNo);
        data.put("status",new Random().nextBoolean());
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        data.put("finishTime", dtf.format(LocalDateTime.now()));
        return data.toJSONString();
    }
}
