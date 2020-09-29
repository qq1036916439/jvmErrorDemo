package com.zzq.leetcode;

import com.zzq.listNode.TreeNode;
import com.zzq.listNode.TreeUtile;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RecoverTree {

	public  void recoverTree(TreeNode root) {
		if(root == null) {
			return;
		}
		LinkedList<TreeNode> list = new LinkedList<>();
		bfs(list,root);
		TreeNode[] nodes=new TreeNode[2];
		int nodeIndex=0;
		for (int i = 1; i < list.size(); i++) {
			if(list.get(i-1).val>list.get(i).val){
				nodes[0]=list.get(i-1);
				nodes[1]=list.get(i);
				continue;
			}
		}
		int tem=nodes[0].val;
		nodes[0].val=nodes[1].val;
		nodes[1].val=tem;
	}
	void bfs(LinkedList<TreeNode> list, TreeNode node){
		if(node==null){
			return;
		}
		bfs(list,node.left);
		list.add(node);
		bfs(list,node.right);
	}

	public static void main(String[] args) {
		RecoverTree recoverTree = new RecoverTree();
		TreeNode root = TreeUtile.buildTree(new Integer[]{1,3,null,null,2}, 0);
		recoverTree.recoverTree(root);
	}
}
