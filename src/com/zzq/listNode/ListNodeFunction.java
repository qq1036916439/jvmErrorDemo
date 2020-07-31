package com.zzq.listNode;

/**
 * @author zhangzhiqiang
 */
public class ListNodeFunction {

    public static ListNode arrayToListNode(int...val){
        ListNode head = new ListNode(0);
        ListNode curr=head;
        for (int i : val) {
            curr.next=new ListNode(i);
            curr=curr.next;
        }
        return head.next;
    }


}
