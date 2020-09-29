package com.zzq.leetcode;

import com.zzq.listNode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class pathSum {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		LinkedList<Integer> path = new LinkedList<>();
		LinkedList<List<Integer>> res = new LinkedList<>();
		bfs(root,path,0,sum,res);
		return res;
	}
	public void bfs(TreeNode root, LinkedList<Integer> path, int sum, int tiager, List<List<Integer>> res){
		if(root==null){
			if(tiager==sum){
			}
			return;
		}
		path.add(root.val);
		bfs(root.left,path,sum+root.val,tiager,res);
		bfs(root.right,path,sum+root.val,tiager,res);
		path.removeLast();
	}
}
