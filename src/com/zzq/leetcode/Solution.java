package com.zzq.leetcode;

import com.zzq.listNode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 */
class Solution {
	int max = Integer.MAX_VALUE;

	public int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		Queue<TreeNode> q = new LinkedList<>();
		int depth = 0;
		q.offer(root);
		while (!q.isEmpty()) {
			depth++;
			int size = q.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = q.poll();
				if (node.left == null && node.right == null) {
					return depth;
				}
				if (node.left != null) {
					q.offer(node.left);
				}
				if (node.right != null) {
					q.offer(node.right);
				}
			}
		}
		return depth;
	}
}