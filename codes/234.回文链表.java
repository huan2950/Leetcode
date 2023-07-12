/*
 * @lc app=leetcode.cn id=234 lang=java
 *
 * [234] 回文链表
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

import utils.*;

class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head.next == null) return true;
        // 确定链表的前半部分和后半部分
        ListNode fast,slow;
        fast = slow = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null){
            slow = slow.next;
        }

        ListNode left = head;
        // 反转后部分链表
        ListNode right = reverse(slow);

        //比较前后链表
        while (right != null) {
            if(left.val != right.val)return false;
            else{
                left = left.next;
                right = right.next;
            }
        }

        return true;

    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
}
// @lc code=end

