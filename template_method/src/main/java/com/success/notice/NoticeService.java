package com.success.notice;

import com.success.notice.vo.NoticeMessage;

/**
 * @Title：通知服务接口
 * @Author：wangchenggong
 * @Date 2020/9/27 11:58
        * @Description 用于通知其他系统接口调用结果
        * @Version
 */
public interface NoticeService<T> {

    T notice(NoticeMessage noticeMessage) throws Exception;
}
