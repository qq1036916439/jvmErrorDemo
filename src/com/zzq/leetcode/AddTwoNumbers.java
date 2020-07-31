package com.zzq.leetcode;

import com.zzq.listNode.ListNode;

import static com.zzq.listNode.ListNodeFunction.arrayToListNode;

/**
 * @author zhangzhiqiang
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode node1 = arrayToListNode(8, 9, 7);
        ListNode node2 = arrayToListNode(8, 9, 7);
        addTwoNumbers(node1,node2);
    }
    /**
     * 两数组
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry=0;
        ListNode node=new ListNode(0);
        ListNode curr=node;
        while (l1!=null||l2!=null){
            int l1Val=l1!=null?l1.val:0;
            int l2Val=l2!=null?l2.val:0;
            int sum=l1Val+l2Val+carry;
            carry=sum/10;
            curr.next=new ListNode(sum%10);
            curr=curr.next;
            if(l1!=null){
                l1=l1.next;
            }
            if(l2!=null){
                l2=l2.next;
            }
            if(carry!=0){
                curr.next=new ListNode(carry);
            }
        }
        return node.next;
    }
}
