package com.zzq;

import com.zzq.listNode.ListNode;

/**
 * //求两个排序区间数组的相交部分，比如A=[(1,3),(5,7)]，B=[(3,6)]，返回[(5,6)]
 *
 * 1-3  5-7
 * 3-6
 */
public class Main {
    public static void getListNode(ListNode head){
        head.next=null;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(2);
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(4);
        ListNode listNode3 = new ListNode(3);

        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
         getListNode(listNode);

    }
}
