package com.zzq.listNode;

/**
 * @author zhangzhiqiang
 */
public class ListNodeFunction {

    public static ListNode arrayToListNode(int... val) {
        ListNode head = new ListNode(0);
        ListNode curr = head;
        for (int i : val) {
            curr.next = new ListNode(i);
            curr = curr.next;
        }
        return head.next;
    }

    /**
     * 按照顺序输出链表
     * @param node
     * @return
     */
    public static void printListNode(ListNode node) {
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }


}
