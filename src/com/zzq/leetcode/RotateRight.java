package com.zzq.leetcode;

import com.zzq.listNode.ListNode;

import java.util.HashSet;
import java.util.List;

import static com.zzq.listNode.ListNodeFunction.arrayToListNode;

public class RotateRight {
	public static ListNode rotateRight(ListNode head, int k) {
		if(head==null){
			return head;
		}
		int length=1;
		ListNode fast=head;
		while (fast.next!=null){
			length++;
			fast=fast.next;
		}
		fast.next=head;
		int m = length - k % length;
		for (int i = 0; i < m; ++i) {
			fast = fast.next;
		}
		ListNode newhead = fast.next;
		fast.next = null;
		return newhead;
	}

	public static void main(String[] args) {
		rotateRight(arrayToListNode(1,2,3,4,5),2);
	}
}
