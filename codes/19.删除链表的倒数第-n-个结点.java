/*
 * @lc app=leetcode.cn id=19 lang=java
 *
 * [19] 删除链表的倒数第 N 个结点
 */

// @lc code=start
/**
 * Definition for singly-linked list.

 */

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p1 = head;
        // p1先走N步
        for (int i = 0; i < n; i++) {
            p1 = p1.next;
        }
        ListNode p2 = head;
        ListNode dummy = new ListNode(-1);//虚拟空节点
        dummy.next = head;
        ListNode p3 = dummy;//p3在p2前面，用于删除p2结点
        while(p1 != null){
            p1 = p1.next;
            p2 = p2.next;
            p3 = p3.next;
        }
        p3.next = p3.next.next;// Skip p2 node
        return dummy.next;
    }
}
// @lc code=end

