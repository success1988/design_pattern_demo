package com.success.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Title：
 * @Author：wangchenggong
 * @Date 2021/6/1 9:02
 * @Description
 * @Version
 */
public class TestLock {


    public static void main(String[] args) throws InterruptedException {

        ReentrantLock lock = new ReentrantLock(true);

        new Thread(() -> {
            lock.lock();
        },"线程1").start();


        new Thread(() -> {
            lock.lock();
        },"线程2").start();


        new Thread(() -> {
            lock.lock();
        },"线程3").start();
    }
}



