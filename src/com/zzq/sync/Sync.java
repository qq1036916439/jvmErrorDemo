package com.zzq.sync;

public class Sync {

    private static Object obj = new Object();

    private int i = 0;

    public synchronized void test() {
        i++;
    }


    public synchronized void test2() {
        synchronized (this) {
            Sync sync = new Sync();
        }
    }

    public synchronized static void test3() {
        synchronized (obj) {
            Sync sync = new Sync();
        }
    }

    public static void main(String[] args) {

    }


}
