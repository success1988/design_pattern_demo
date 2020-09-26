package com.success.uniformApiInvoker;


import com.success.uniformApiInvoker.impl.ElectronicSignatureServiceImpl;
import com.success.uniformApiInvoker.impl.SignProtocalServiceImpl;
import com.success.uniformApiInvoker.req.ElectronicSignatureRequest;
import com.success.uniformApiInvoker.req.SignProtocalRequest;
import com.success.uniformApiInvoker.res.ElectronicSignatureResponse;
import com.success.uniformApiInvoker.res.SignProtocalResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Title：调用外部服务的统一接口测试用例
 * @Author：wangchenggong
 * @Date 2020/9/26 6:28
 * @Description
 * @Version
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class InvokeOuterSystemServiceTest {


    @Autowired
    private SignProtocalServiceImpl signProtocalService;

    @Autowired
    private ElectronicSignatureServiceImpl electronicSignatureService;

    @Test
    public void requestTest() throws Exception {
        SignProtocalResponse signProtocalResponse = signProtocalService.request(new SignProtocalRequest());
        System.out.println(signProtocalResponse);

        ElectronicSignatureResponse electronicSignatureResponse = electronicSignatureService.request(new ElectronicSignatureRequest());
        System.out.println(electronicSignatureResponse);

    }
}