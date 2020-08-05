package com.zzq.leetcode;

import com.zzq.listNode.ListNode;

import static com.zzq.listNode.ListNodeFunction.arrayToListNode;
import static com.zzq.listNode.ListNodeFunction.printListNode;

/**
 * @author zhangzhiqiang
 */
public class oddEvenList {
    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        ListNode node1 = head;
        ListNode node2 = head.next;
        ListNode head2 = node2;
        node1.next = node2.next;
        while (node1 != null && node2 != null) {
            node1.next = node2.next;
            if (node1.next == null) {
                break;
            }
            node1 = node1.next;
            node2.next = node1.next;
            node2 = node2.next;
        }
        node1.next = head2;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = arrayToListNode(1, 2, 3, 4, 5, 6, 7, 8);
        oddEvenList(head);
        printListNode(head);
    }

}
