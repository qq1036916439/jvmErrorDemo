package com.zzq;

/**
 * //求两个排序区间数组的相交部分，比如A=[(1,3),(5,7)]，B=[(3,6)]，返回[(5,6)]
 *
 * 1-3  5-7
 * 3-6
 */
public class Main {
    public static void main(String[] args) {
        longestPalindrome("aaaa");

    }


    public static String longestPalindrome(String s) {
        if (s.length() == 0) {
            return "";
        }
        boolean[][] dp = new boolean[s.length()][s.length()];
        int maxlenght = 1;
        char[] chars = s.toCharArray();
        for (int i = 0; i < 0; i++) {
            dp[i][i] = true;
        }
        String longestPalindrom = chars[0] + "";
        for (int r = 1; r < chars.length; r++) {
            for (int l = 0; l < r; l++) {
                if (chars[l] == chars[r] && (r - l < 3 || dp[l + 1][r - 1])) {
                    dp[l][r]=true;
                    if (r - l +1> maxlenght) {
                        maxlenght = r - l + 1;
                        longestPalindrom = s.substring(l, r + 1);
                    }
                }

            }
        }
        return longestPalindrom;

    }
}
