package route_validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.List;

/**
 * @Title：路由校验器链
 * @Author：wangchenggong
 * @Date 2021/1/23 9:57
 * @Description 由一组路由校验器来校验候选路由是否符合要求
 * @Version
 */
@Component
public class RouteValidatorChain implements RouteValidator{


    @Autowired
    private List<BaseRouteValidator> routeValidatorList;


    /**
     * 按照优先级对各路由校验器排序
     */
    @PostConstruct
    public void sortRouteValidatorsByPriority(){
        if(!CollectionUtils.isEmpty(routeValidatorList)){
            Collections.sort(routeValidatorList);
        }
    }


    /**
     *  对各路由校验器依次调用校验方法
     *      如果某个校验器不通过，则停止；如果通过，则调用后续校验器
     * @param channel 候选通道
     * @return
     */
    @Override
    public boolean validate(Channel channel){
        if(!CollectionUtils.isEmpty(routeValidatorList)){
            for (BaseRouteValidator routeValidator : routeValidatorList) {
                boolean isOK = routeValidator.validate(channel);
                if(!isOK){
                    return false;
                }
            }
        }
        return true;
    }


}
