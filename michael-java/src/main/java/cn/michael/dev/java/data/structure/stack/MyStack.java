package cn.michael.dev.java.data.structure.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hufenggang on 2021/7/6.
 */
public class MyStack {
    private List<Integer> data;

    public MyStack() {
        data = new ArrayList<>();
    }

    /**
     * 入栈
     *
     * @param x
     */
    public void push(int x) {
        data.add(x);
    }

    public Boolean isEmpty() {
        return data.isEmpty();
    }

    public int top() {
        return data.get(data.size() - 1);
    }

    /**
     * 出栈
     *
     * @return
     */
    public Boolean pop() {
        if(isEmpty()) {
            return false;
        }
        data.remove(data.size() - 1);
        return true;
    }
}
