package without_flag;

/**
 * @Title：
 * @Author：wangchenggong
 * @Date 2021/1/20 16:47
 * @Description
 * @Version
 */
public class BHandler implements IHandler{
    @Override
    public void handle() {
        System.out.println("B Handler处理业务逻辑");
    }
}
