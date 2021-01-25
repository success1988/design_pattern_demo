package route_validator.impl;

import org.springframework.stereotype.Component;
import route_validator.BaseRouteValidator;
import route_validator.Channel;

/**
 * @Title：分账校验器
 * @Author：wangchenggong
 * @Date 2021/1/25 11:21
 * @Description
 * @Version
 */
@Component
public class SharePayRouteValidatorImpl implements BaseRouteValidator {

    @Override
    public boolean validate(Channel channel) {
        //TODO 这里校验是否支持分账（如果需要当前路由支持分账时）
        return true;
    }

    @Override
    public int getPriority() {
        return 3;
    }
}
