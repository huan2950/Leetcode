/*
 * @lc app=leetcode.cn id=86 lang=java
 *
 * [86] 分隔链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        // 核心原理是将一个链表分成两个链表
        // 两个链表的头节点
        ListNode head1 = new ListNode(-1);
        ListNode head2 = new ListNode(-1);
        // p1是小于x的数组成的链表，p2是大于等于x的数组成的链表
        ListNode p1 = head1, p2 = head2;
        ListNode p = head;
        while( p != null){
            if (p.val >= x){
                // 延长链表2
                p2.next = p;
                p2 = p2.next;
            }else{
                // 延长链表1
                p1.next = p;
                p1 = p1.next;
            }
            p = p.next;
            
        }
        // 将大链表接到小链表的后面
        // 前提是大链表的末尾要先指向空
        p2.next = null;
        p1.next = head2.next;
        return head1.next;
    }

}
// @lc code=end

