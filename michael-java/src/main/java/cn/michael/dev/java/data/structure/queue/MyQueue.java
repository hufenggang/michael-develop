package cn.michael.dev.java.data.structure.queue;

import java.util.List;

/**
 * Created by hufenggang on 2021/7/6.
 */
public class MyQueue {
    private List<Integer> data;
    // 起点
    private int pStart;

    public MyQueue() {
    }

    public boolean enQueue(int x) {
        data.add(x);
        return true;
    }

    public boolean isEmpty() {
        return pStart >= data.size();
    }
}
