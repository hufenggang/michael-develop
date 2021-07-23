package cn.michael.dev.java.data.structure.queue;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hufenggang on 2021/6/11.
 *
 * 动态数组和指向队列头部的索引
 */
public class MyQueue {
    private List<Integer> data;
    private int p_start;

    public MyQueue() {
        data = new ArrayList<Integer>();
        p_start = 0;
    }

    /**
     * 入队
     *
     * @param x
     * @return
     */
    public boolean enQueue(int x) {
        data.add(x);
        return true;
    }

    /**
     * 出队
     *
     * @return
     */
    public boolean deQueue() {
        if (isEmpty() == true) {
            return false;
        }

        p_start ++;
        return true;
    }

    public boolean isEmpty() {
        return p_start >= data.size();
    }

    /**
     * 获取队首元素
     *
     * @return
     */
    public int front() {
        return data.get(p_start);
    }


    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.enQueue(5);
        myQueue.enQueue(3);

        if (!myQueue.isEmpty()) {
            System.out.println(myQueue.front());
        }
        myQueue.deQueue();

        if (!myQueue.isEmpty()) {
            System.out.println(myQueue.front());
        }
        myQueue.deQueue();

        if (!myQueue.isEmpty()) {
            System.out.println(myQueue.front());
        }
    }
}
