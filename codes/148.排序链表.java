/*
 * @lc app=leetcode.cn id=148 lang=java
 *
 * [148] 排序链表
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

import java.util.List;

// import utils.ListNode;

// import utils.ListNode;

/**
 * 思路：要时间复杂度为O(nlogn)，排序算法可以为：归并排序、堆排序、快速排序
 * 链表适合使用归并排序
 * 将链表分成两份(快慢指针)，排序后进行归并
 */
class Solution {
    public ListNode sortList (ListNode head){
        if (head == null || head.next == null)return head;

        // 找到中点
        ListNode mid = findMidNode(head);
        // 根据中点切开链表
        ListNode tmp = mid.next;
        mid.next = null;
        // 递归
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);
        // 合并链表
        ListNode h = new ListNode(0);
        ListNode res = h;
        while (left != null && right != null) {
            if (left.val < right.val) {
                h.next = left;
                left = left.next;
            } else {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }
        h.next = left != null ? left : right;
        return res.next;
    }

    public ListNode findMidNode (ListNode head){
        ListNode slow = head,fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
// @lc code=end

