package com.zzq.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PermuteUnique {
	private static List<List<Integer>> res = new ArrayList<>();

	public static List<List<Integer>> permuteUnique(int[] nums) {
		Arrays.sort(nums);
		bfs(new LinkedList<>(), nums, 0, new boolean[nums.length]);
		return res;
	}

	private static void bfs(LinkedList<Integer> list, int[] nums, int index, boolean[] used) {

		if (list.size() == nums.length) {
			res.add(new ArrayList<>(list));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (used[i]) {
				continue;
			}
			if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1]) {
				continue;
			}
			list.add(nums[i]);
			used[i] = true;
			bfs(list, nums, i + 1, used);
			used[i] = false;
			list.removeLast();
		}
	}
}
