package com.skycong.factory;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author RMC 2019/7/6 17:43
 */
public class ThreadPool {

    private static final ThreadPoolExecutor EXECUTOR = new ThreadPoolExecutor(
            500,
            2000,
            10,
            TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(10000));


    public static void execute(Runnable runnable) {
        EXECUTOR.submit(runnable);
    }

    public static void close() {
        EXECUTOR.shutdown();
    }


    public static void main(String[] args) {

    }
}
