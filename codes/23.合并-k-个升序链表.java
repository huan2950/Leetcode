/*
 * @lc app=leetcode.cn id=23 lang=java
 *
 * [23] 合并K个升序链表
 */

// @lc code=start

import java.util.PriorityQueue;

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
// import utils.ListNode;
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(
            lists.length, (o1,o2) -> (o1.val - o2.val)
        );
        // 初始化queue
        for(ListNode node: lists){
            if (node != null)
            queue.add(node);
        }
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        while (!queue.isEmpty()){
            ListNode node = queue.poll();
            p.next = node;
            if (node.next != null)
            queue.add(node.next);
            p = p.next;
        }
        return dummy.next;
    }

    
}
// @lc code=end

