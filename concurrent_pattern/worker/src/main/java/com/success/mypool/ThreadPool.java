package com.success.mypool;

/**
 * @Title：线程池接口
 * @Author：wangchenggong
 * @Date 2021/5/20 10:14
 * @Description
 * @Version
 */
public interface ThreadPool<Job extends Runnable> {

    /**
     * 执行一个Job，这个Job需要实现Runnable
     * @param job
     */
    void execute(Job job);

    /**
     * 关闭线程池
     */
    void shutdown();

    /**
     * 增加工作者线程
     * @param num
     */
    void addWorkers(int num);

    /**
     * 减少工作者线程
     * @param num
     */
    void removeWorkers(int num);


    /**
     * 得到正在等待执行的任务数量
     * @return
     */
    int getJobSize();

}
