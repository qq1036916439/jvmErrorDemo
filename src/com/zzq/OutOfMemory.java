package com.zzq;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class OutOfMemory {

    /**
     * 使用如下参数运行JVM即会产生。
     * java.lang.OutOfMemoryError: Java heap space
     * JVM参数：
     * -Xms5m -Xmx5m -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=./jvm.dump
     * 使用-XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=./jvm.dump
     * 可以使代码在发生 java.lang.OutOfMemoryError: Java heap space时生成一份内存快照用于分析堆溢出的原因。
     *
     */
    public static void heapSpace() {
        long[] longs = new long[1000000];
    }

    /**
     * Exception in thread "main" java.lang.OutOfMemoryError: unable to create new native thread
     * 一个JVM进程能创建多少个线程主要受内存空间控制。其次也受到用户空间(user space)文件数量的控制。
     */
    public static void unableToCreateThread() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10000, 10000, 100L, TimeUnit.MINUTES, new LinkedBlockingQueue<>());
        for (int i = 0; i < 10000; i++) {
            threadPoolExecutor.execute(() -> {
            });
        }
    }

    /**
     * java.lang.OutOfMemoryError:GC over head limit exceeded
     * gc了但是必须效果并不理想
     */
    public static void gcNotEffect(){
        long[] longs = new long[100000];
        System.gc();
        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // heapSpace();
        //unableToCreateThread();
        gcNotEffect();
    }


}
