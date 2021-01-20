package with_flag;

/**
 * @Title：
 * @Author：wangchenggong
 * @Date 2021/1/20 10:17
 * @Description
 * @Version
 */
public class HandlerA extends Handler{

    @Override
    public boolean doHandle() {
        System.out.println("我的处理器A,执行处理器A的业务逻辑");
        return true;
    }
}
