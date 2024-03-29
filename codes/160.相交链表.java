/*
 * @lc app=leetcode.cn id=160 lang=java
 *
 * [160] 相交链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
import utils.ListNode;

class Solution {
    /*
     * 两个指针分别遍历两个链表，遍历一个结束后就遍历另一个，重合的地方就是相交节点
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;
        while(p1 != p2){// 相交处p1和p2重合
            if (p1 == null)// p1遍历A链表，遍历完了就遍历B链表
                p1 = headB;
            else 
                p1 = p1.next;
            if (p2 == null)// p2遍历B链表，遍历完了就遍历A链表
                p2 = headA;
            else 
                p2 = p2.next;
        }
        return p1;
    }
}
// @lc code=end

