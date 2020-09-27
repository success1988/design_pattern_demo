package com.success.notice;


import com.success.notice.impl.RechargeNoticeServiceImpl;
import com.success.notice.impl.WithdawNoticeServiceImpl;
import com.success.notice.vo.NoticeMessage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Title：消息通知测试用例
 * @Author：wangchenggong
 * @Date 2020/9/27 18:27
 * @Description
 * @Version
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class NoticeServiceTest {

    @Autowired
    private WithdawNoticeServiceImpl withdawNoticeService;
    @Autowired
    private RechargeNoticeServiceImpl rechargeNoticeService;

    @Test
    public void noticeTest() throws Exception {
        NoticeMessage withdawNoticeMessage = new NoticeMessage();
        withdawNoticeMessage.setUniqueNo("234353456");
        withdawNoticeMessage.setServiceName("withdraw");
        withdawNoticeMessage.setSystemCode("aaa");
        withdawNoticeService.notice(withdawNoticeMessage);

        NoticeMessage rechargeNoticeMessage = new NoticeMessage();
        rechargeNoticeMessage.setUniqueNo("sfrsrwer56");
        rechargeNoticeMessage.setServiceName("recharge");
        rechargeNoticeMessage.setSystemCode("bbb");
        rechargeNoticeService.notice(rechargeNoticeMessage);
    }
}