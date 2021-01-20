package without_flag;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title：基于数组的职责链，无阻断标识
 * @Author：wangchenggong
 * @Date 2021/1/20 16:49
 * @Description
 * @Version
 */
public class HandlerChainByArray {

    private List<IHandler> handlerList = new ArrayList<>();

    public final void  addHandler(IHandler handler){
        handlerList.add(handler);
    }

    public void handle(){
        if(!CollectionUtils.isEmpty(handlerList)){
            for (IHandler handler:handlerList){
                handler.handle();
            }
        }
    }
}
