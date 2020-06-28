package com.zzq.oom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class OutOfMemory {

    /**
     * 使用如下参数运行JVM即会产生。
     * java.lang.OutOfMemoryError: Java heap space
     * JVM参数：
     * -Xms5m -Xmx5m -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=./jvm.hprof
     * 使用-XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=./jvm.hprof
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
     * java.lang.OutOfMemoryError:GC over head limit exceeded .此方法并不会抛出此异常。
     * 这个异常很难复现。但是本方法可以产生一个频繁full gc的log。
     * gc了但是必须效果并不理想，可以使用次参数。此异常并不会中断当前线程
     * -Xms3m -Xmx3m -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=./jvm.hprof -Xloggc:./gc.log
     */
    public static void gcNotEffect() {
        Executor executor = new ThreadPoolExecutor(2, 2, 10000L, TimeUnit.MINUTES, new LinkedBlockingQueue<>());
        executor.execute(() -> {
            long[] longs = new long[260000];
            try {
                Thread.sleep(10000);
                long[] ref = longs;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executor.execute(() -> {
            LinkedList<Object> objects = new LinkedList<>();
            for (int i = 0; i < 500000; i++) {
                boolean add = objects.add(new Object());
                System.gc();
            }

        });

    }

    /**
     * Direct buffer memory堆外内存溢出。常见场景 使用NIO包下内容。
     *-Xms3m -Xmx3m -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=./jvm.dump -Xloggc:./gc.log -XX:MaxDirectMemorySize=1m -verbose:gc -XX:+PrintGCDetails
     */
    public static void directMemory() {
        List<ByteBuffer> list = new ArrayList<ByteBuffer>();
        while (true) {
            ByteBuffer buffer = ByteBuffer.allocateDirect(1 * 1024 * 1024);
            list.add(buffer);
        }
    }


    public static void main(String[] args) {
        heapSpace();
        //unableToCreateThread();
       // gcNotEffect();
       // directMemory();
    }


}
