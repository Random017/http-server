package com.skycong.factory;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author RMC 2019/7/6 17:43
 */
public class ThreadPool {

    private static final ThreadPoolExecutor EXECUTOR = new ThreadPoolExecutor(
            20,
            200,
            60,
            TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(600));


    public static void execute(Runnable runnable) {
        EXECUTOR.submit(runnable);
    }

    public static void close() {
        EXECUTOR.shutdown();
    }
}
