package jdk_iterator_demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @Title：
 * @Author：wangchenggong
 * @Date 2021/1/22 9:10
 * @Description
 * @Version
 */
public class TestListIterator {

    public static void main(String[] args) {

        List<String> names = new LinkedList<>();
        names.add("a");
        names.add("b");
        names.add("c");
        names.add("d");

        Iterator<String> iterator1 = names.iterator();
        Iterator<String> iterator2 = names.iterator();
        iterator1.next();
        iterator1.remove();
        iterator2.next(); // 运行结果？ConcurrentModificationException
        //之所以发生并发修改异常，是因为iterator1中的expectModCount已经在其remove()方法中重置为5，而iterator2的expectModCount却还是4
    }
}
