package com.zzq.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PermuteUnique {
	private static   List<List<Integer>> res = new ArrayList<>();

	public static List<List<Integer>> permuteUnique(int[] nums) {
		Arrays.sort(nums);
		bfs(new LinkedList<>(),nums,0);
		return res;
	}

	private static void bfs(LinkedList<Integer> list, int[] nums,int index) {
		if (list.size() == nums.length) {
			res.add(new ArrayList<>(list));
			return ;
		}
		for(int i=index;i<nums.length;i++){
			if(list.contains(nums[i])||i>0&&nums[i]==nums[i-1]){
				continue;
			}
			list.add(nums[i]);
			bfs(list,nums,i);
			list.removeLast();
		}
	}

	public static void main(String[] args) {
		permuteUnique(new int[]{1,1,2});
		boolean[] booleans = new boolean[100];
	}
}
