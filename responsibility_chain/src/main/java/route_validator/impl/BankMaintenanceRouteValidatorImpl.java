package route_validator.impl;

import org.springframework.stereotype.Component;
import route_validator.BaseRouteValidator;
import route_validator.Channel;

/**
 * @Title：银行维护时间校验器
 * @Author：wangchenggong
 * @Date 2021/1/25 11:21
 * @Description
 * @Version
 */
@Component
public class BankMaintenanceRouteValidatorImpl implements BaseRouteValidator {

    @Override
    public boolean validate(Channel channel) {
        //TODO 这里校验当前路由是否处于银行维护时间段以内
        return true;
    }

    @Override
    public int getPriority() {
        return 0;
    }
}
