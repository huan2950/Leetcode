/*
 * @lc app=leetcode.cn id=25 lang=java
 *
 * [25] K 个一组翻转链表
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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) return null;
        ListNode last = head;
        for (int i = 0; i < k; i++) {
            if(last == null) return head;
            last = last.next;//last节点为下一次reverseKGroup()的head节点
        }
        
        ListNode newHead = reverseN(head,k);
        head.next = reverseKGroup(last,k);
        return newHead;

    }


    ListNode successor = null; // 后驱节点
    /**
     * 反转链表的前k个结点
     * @param head 头节点
     * @param k 
     * @return 反转后的头节点
     */
    public ListNode reverseN(ListNode head, int k) {
        if (k == 1){
            successor = head.next;
            return head;
        }

        ListNode last = reverseN(head.next,k-1);

        head.next.next = head;
        head.next = successor;
        return last;

    }
}
// @lc code=end

