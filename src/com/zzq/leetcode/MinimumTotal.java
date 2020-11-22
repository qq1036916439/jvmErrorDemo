package com.zzq.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * :[[2],[3,4],[6,5,7],[4,1,8,3]]
 * @author zhangzhiqiang
 */
public class MinimumTotal {
	public static int minimumTotal(List<List<Integer>> triangle) {
		int[][] dp = new int[triangle.size()][triangle.get(triangle.size() - 1).size()];
		int res = Integer.MAX_VALUE;
		dp[0][0] = triangle.get(0).get(0);
		for (int i = 0; i < triangle.size(); i++) {
			for (int j = 0; j < triangle.get(0).size(); j++) {
				dp[i][j] = triangle.get(i).get(j);
			}
		}

		for (int i = 1; i < triangle.size(); i++) {
			for (int j = 0; j < triangle.get(i).size(); j++) {
				if (i == 0) {
					dp[i][j] = dp[i - 1][j] + triangle.get(i).get(j);
					continue;
				}
				if (i == 1) {
					dp[i][j] = dp[i - 1][j] + triangle.get(i).get(j);
					continue;
				}
				if (j == 1) {
					dp[i][j] = dp[i][j-1] + triangle.get(i).get(j);
					continue;
				}
				if (j == 0) {
					dp[i][j] = dp[i-1][j] + triangle.get(i).get(j);
					continue;
				}
				dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle.get(i).get(j);
				if (i == triangle.size() - 1) {
					res = Math.min(dp[i][j], res);
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		List<List<Integer>> res = new ArrayList<>();

		ArrayList<Integer> list1 = new ArrayList<>();
		list1.add(2);
		ArrayList<Integer> list2 = new ArrayList<>();
		list2.add(3);
		list2.add(4);
		ArrayList<Integer> list3 = new ArrayList<>();
		list3.add(6);
		list3.add(5);
		list3.add(7);
		ArrayList<Integer> list4 = new ArrayList<>();
		list4.add(4);
		list4.add(1);
		list4.add(8);
		list4.add(3);
		res.add(list1);
		res.add(list2);
		res.add(list3);
		res.add(list4);
		System.out.println(minimumTotal(res));
	}
}
