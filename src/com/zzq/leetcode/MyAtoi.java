package com.zzq.leetcode;

/**
 * @author zhangzhiqiang
 */
public class MyAtoi {

    public static void main(String[] args) {
        myAtoi("-2147483649");
    }

    public static int myAtoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        char[] chars = str.toCharArray();
        int index = 0;
        while (index < chars.length && chars[index] == ' ') {
            index++;
        }
        int flag = 1;
        if (index < chars.length && chars[index] == '-') {
            flag = -1;
            index++;
        } else {
            if (index < chars.length && chars[index] == '+') {
                index++;
            }
        }
        int result = 0;
        while (index < chars.length) {
            if ((chars[index] < 48 || chars[index] > 57)) {
                break;
            }
            if (result > Integer.MAX_VALUE / 10 || ((result == Integer.MAX_VALUE / 10) && chars[index] - 48 >= Integer.MAX_VALUE % 10)) {
                return Integer.MAX_VALUE;
            }
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && -(chars[index] - 48) <= Integer.MIN_VALUE % 10)) {
                return Integer.MIN_VALUE;
            }
            result = (chars[index] - 48) * flag + result * 10;
            index++;
        }
        return result;
    }
}
