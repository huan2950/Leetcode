/*
 * @lc app=leetcode.cn id=24 lang=java
 *
 * [24] 两两交换链表中的节点
 */

// @lc code=start

import utils.ListNode;

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
    /*
     * 思路：虚拟头结点+模拟
     * cur = dummy
     * 
     */
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null ){
            ListNode last = cur.next.next;// 交换的后一个元素
            ListNode start = cur.next;//交换的前一个元素
            cur.next = last;
            start.next = last.next;
            last.next = start;
            cur = start;
        }
        return dummy.next;
    }
}

// class Solution {
//     public ListNode swapPairs(ListNode head) {
//         ListNode pre = new ListNode(0);
//         pre.next = head;
//         ListNode temp = pre;
//         while(temp.next != null && temp.next.next != null) {
//             ListNode start = temp.next;
//             ListNode end = temp.next.next;
//             temp.next = end;
//             start.next = end.next;
//             end.next = start;
//             temp = start;
//         }
//         return pre.next;
//     }
// }
// @lc code=end

