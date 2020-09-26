package com.success.uniformApiProvider;

import com.alibaba.fastjson.JSONObject;
import com.success.uniformApiProvider.impl.BindCardServiceImpl;
import com.success.uniformApiProvider.impl.OpenAccountServiceImpl;
import com.success.uniformApiProvider.req.BindCardRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * @Title：对外提供服务接口测试用例
 * @Author：wangchenggong
 * @Date 2020/9/26 11:02
 * @Description
 * @Version
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FacadeApiServiceTest {

    @Autowired
    private BindCardServiceImpl bindCardService;
    @Autowired
    private OpenAccountServiceImpl openAccountService;

    @Test
    public void  handleTest(){
        RequestMessage<JSONObject> bindCardReq = new RequestMessage<>();
        JSONObject bindCardObj = new JSONObject();
        bindCardObj.put("requestNo","234ewrw3534");
        bindCardReq.setData(bindCardObj);
        String bindCardResponseMsg = bindCardService.handle(bindCardReq);
        System.out.println("绑卡处理结果为："+bindCardResponseMsg);

        RequestMessage<JSONObject> openAccountReq = new RequestMessage<>();
        JSONObject openAccountObj = new JSONObject();
        openAccountObj.put("requestNo","111ewrw3534");
        openAccountReq.setData(openAccountObj);
        String openAccountResponseMsg = openAccountService.handle(openAccountReq);
        System.out.println("绑卡处理结果为："+openAccountResponseMsg);
    }
}