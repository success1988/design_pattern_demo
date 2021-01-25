package route_validator.impl;

import org.springframework.stereotype.Component;
import route_validator.BaseRouteValidator;
import route_validator.Channel;

/**
 * @Title：银行限额校验器
 * @Author：wangchenggong
 * @Date 2021/1/25 11:21
 * @Description
 * @Version
 */
@Component
public class BankLimitRouteValidatorImpl implements BaseRouteValidator {

    @Override
    public boolean validate(Channel channel) {
        //TODO 这里校验当前路由是否满足银行限额的要求
        return true;
    }

    @Override
    public int getPriority() {
        return 1;
    }
}
