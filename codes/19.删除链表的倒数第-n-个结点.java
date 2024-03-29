/*
 * @lc app=leetcode.cn id=19 lang=java
 *
 * [19] 删除链表的倒数第 N 个结点
 */

// @lc code=start

import utils.ListNode;

/**
 * Definition for singly-linked list.

 */

class Solution {
    /*
     * 思路：快慢指针
     * 快指针先走N步，然后快慢指针同时走，当快指针到达末尾时，慢指针所在的节点都是倒数第N个节点
     * 要删除慢指针所在的节点，还要记录其前驱节点prev
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p1 = head;
        // 快指针先走N步
        for (int i = 0; i < n; i++) {
            p1 = p1.next;
        }
        ListNode p2 = head;// 慢指针
        ListNode dummy = new ListNode(-1);//虚拟空节点
        dummy.next = head;
        // 慢指针的前驱节点
        ListNode p3 = dummy;//p3在p2前面，用于删除p2结点
        while(p1 != null){
            p1 = p1.next;
            p2 = p2.next;
            p3 = p3.next;
        }
        // 快指针到末尾，此时删除慢指针
        p3.next = p3.next.next;// Skip p2 node
        return dummy.next;
    }
}
// @lc code=end

