package with_flag;

/**
 * @Title：处理器抽象类
 * @Author：wangchenggong
 * @Date 2021/1/20 9:16
 * @Description
 * @Version
 */
public abstract class Handler {

    protected Handler nextHandler = null;

    public final void setNextHandler(Handler handler){
        this.nextHandler = handler;
    }

    /**
     * 处理器的模板方法
     */
    public final void handle(){

        boolean isNeedDoNext = this.doHandle();

        if(isNeedDoNext && nextHandler != null){
            nextHandler.handle();
        }
    }


    /**
     * 处理器的业务逻辑
     * @return 是否需要继续执行后续处理器的逻辑   true继续执行后续处理逻辑 ，  false 不再执行后续处理逻辑
     */
    public abstract boolean doHandle();

}
