package com.success.notice;

import com.alibaba.fastjson.JSON;
import com.success.notice.vo.NoticeMessage;
import com.success.notice.vo.NoticeResult;
import com.success.util.HttpClientUtil;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @Title：通知服务基类
 * @Author：wangchenggong
 * @Date 2020/9/27 13:41
 * @Description
 * @Version
 */
public abstract class AbstractNoticeService  implements NoticeService<NoticeResult>{

    /**
     * 模拟数据字典中 不同系统的通知地址
     */
    private static Map<String,String> noticeUrlMap = new HashMap<>();
    static {
        noticeUrlMap.put("aaa","http://xxx/aaa/");
        noticeUrlMap.put("bbb","http://xxx/bbb/");
    }

    @Override
    public NoticeResult notice(NoticeMessage noticeMessage) throws Exception {

        NoticeResult noticeResult = null;

        //1.获取通知地址(不同系统的通知地址一般可以配置在数据字典中，可以从数据字典中获取)
        String noticeUrl = noticeUrlMap.get(noticeMessage.getSystemCode());

        //2.构建通知内容
        String noticeContent = this.buildNoticeContent(noticeMessage.getUniqueNo());

        //3.发送通知内容
        String result = HttpClientUtil.doPostJson(noticeUrl, noticeContent);
        if(!StringUtils.isEmpty(result)){
            try{
                noticeResult = JSON.parseObject(result, NoticeResult.class);

                //4.更新通知状态
                this.updateNoticeStatus(noticeResult, noticeMessage);
            }catch (Exception e){
                noticeResult = new NoticeResult("9001", "The result of notice is empty!");
            }
        }else{
            noticeResult = new NoticeResult("9001", "The noticeUrl is empty!");
        }

        return  noticeResult;
    }

    /**
     * 更新通知状态
     * @param noticeResult 通知结果
     * @param noticeMessage 通知的消息信息
     */
    protected abstract void updateNoticeStatus(NoticeResult noticeResult, NoticeMessage noticeMessage);

    /**
     * 根据通知消息ID构建消息通知内容
     * @param uniqueNo
     * @return
     */
    protected abstract String buildNoticeContent(String uniqueNo);





}
