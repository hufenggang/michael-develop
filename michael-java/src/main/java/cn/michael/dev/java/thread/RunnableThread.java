package cn.michael.dev.java.thread;

/**
 * Created by hufenggang on 2021/6/30.
 */
public class RunnableThread implements Runnable {
    private int THREAD_NUM = 10;

    @Override
    public void run() {
        for (int i = 0; i < THREAD_NUM; i++) {
            System.out.println("线程" + Thread.currentThread() + " " + i);
        }
    }
}
