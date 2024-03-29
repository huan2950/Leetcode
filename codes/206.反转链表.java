/*
 * @lc app=leetcode.cn id=206 lang=java
 *
 * [206] 反转链表
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
import utils.ListNode;

// class Solution {
//     /*
//      * 思路：递归
//      */
//     public ListNode reverseList(ListNode head) {
//         // 递归返回条件
//         if (head == null || head.next == null) {
//             return head;
//         }
//         ListNode last = reverseList(head.next);
//         head.next.next = head;
//         head.next = null;
//         return last;
//     }
// }

class Solution {
    /*
     * 思路：双指针pre和cur,改变cur的next指针指向之前先保存一下原本的cur.next
     */
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        ListNode temp = null;
        while (cur != null) {
            temp = cur.next;// 保存cur下一个节点
            cur.next = prev;// 改变cur.next指向
            // 指针后移
            prev = cur;
            cur = temp;
        }
        return prev;
    }
}
// @lc code=end

