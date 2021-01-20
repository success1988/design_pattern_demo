package with_flag;

/**
 * @Title：测试处理器链
 * @Author：wangchenggong
 * @Date 2021/1/20 10:18
 * @Description
 * @Version
 */
public class TestChain {

    public static void main(String[] args) {
        HandlerChain handlerChain = new HandlerChain();
        handlerChain.addHandler(new HandlerA());
        handlerChain.addHandler(new HandlerB());
        handlerChain.handle();
    }
}
