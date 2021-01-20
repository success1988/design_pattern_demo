package with_flag;

/**
 * @Title：处理器链
 * @Author：wangchenggong
 * @Date 2021/1/20 10:12
 * @Description
 * @Version
 */
public class HandlerChain {

    private Handler head;
    private Handler tail;


    public void addHandler(Handler handler){

        handler.setNextHandler(null);
        if(head == null){
            head = handler;
            tail = handler;
            return;
        }

        //将当前的尾节点的next指针指向要新添加的这个节点
        tail.nextHandler = handler;
        //将新添加的这个节点作为处理器链的尾节点
        tail = handler;
    }


    public void handle(){
        if(head != null){
            head.handle();
        }
    }



}
