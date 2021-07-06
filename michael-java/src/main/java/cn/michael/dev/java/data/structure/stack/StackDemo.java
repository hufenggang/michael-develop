package cn.michael.dev.java.data.structure.stack;

import java.util.Stack;

/**
 * Created by hufenggang on 2021/7/6.
 */
public class StackDemo {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(10);
        stack.push(14);
        stack.push(22);

        if (stack.isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }

        stack.pop();
        stack.pop();
        System.out.println(stack.peek());
        System.out.println(stack.size());

    }
}
