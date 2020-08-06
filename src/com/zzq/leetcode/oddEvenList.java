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
        ListNode o = head;
        ListNode e = head.next;
        ListNode p = e;
        while (o != null && e != null) {
            o.next = e.next;
            o = o.next;
            o.next = o.next;
            e = e.next;
        }
        e.next = p;
        return head;
    }

    /**
     * public:
     *     ListNode* oddEvenList(ListNode* head) {
     *         if(!head||!head->next||!head->next->next) return head;
     *         // 指向奇链表结尾
     *         ListNode* o = head;
     *         // 指向偶链表结尾
     *         ListNode* e = head->next;
     *         // 指向偶链表开头
     *         ListNode* p = e;
     *
     *         // 将奇偶节点分别加入到对应的链表中
     *         while(o->next&&e->next){
     *             o->next = e->next;
     *             o = o->next;
     *             e->next = o->next;
     *             e = e->next;
     *         }
     *
     *         // 拼接两个链表
     *         o->next = p;
     *         return head;
     *     }
     * };
     */
    public static void main(String[] args) {
        ListNode head = arrayToListNode(1, 2, 3, 4, 5, 6, 7, 8);
        oddEvenList(head);
        printListNode(head);
    }

}
