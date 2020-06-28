package com.zzq.oom;

/**
 * 演示栈溢出的代码
 * @author zhangzhiqiang
 */
public class StackOver {
    /**
     * 这里使用没有终止条件的递归调用,方法不断的进行压栈操作。即会产生StackOverflowError异常。
     * 在默认情况下64位JVM下默认的栈大小为1M。在一些调用栈比较长的代码中可能出现。
     */
    static void function() {
        function();
    }

    public static void main(String[] args) {
        function();
    }

}
