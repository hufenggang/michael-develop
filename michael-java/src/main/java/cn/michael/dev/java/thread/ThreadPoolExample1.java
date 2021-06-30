package cn.michael.dev.java.thread;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by hufenggang on 2021/6/30.
 *
 * 线程池方式创建线程。
 */
public class ThreadPoolExample1 {
    private static int POOL_NUM = 10;

    public static void main(String[] args) throws InterruptedException {

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
            5,
            5,
            1,
            TimeUnit.SECONDS,
            new LinkedBlockingDeque<>(100),
            Executors.defaultThreadFactory(),
            new ThreadPoolExecutor.AbortPolicy()
        );

        for (int i = 0; i < POOL_NUM; i++) {
            RunnableThread runnableThread = new RunnableThread();
            threadPoolExecutor.execute(runnableThread);
        }

        threadPoolExecutor.shutdown();
        threadPoolExecutor.awaitTermination(10, TimeUnit.SECONDS);

    }
}
