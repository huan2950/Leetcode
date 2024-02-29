/*
 * @lc app=leetcode.cn id=83 lang=java
 *
 * [83] 删除排序链表中的重复元素
 */

// @lc code=start

// import java.util.HashSet;
// import java.util.Set;

// import utils.ListNode;

// import utils.ListNode;

//  Definition for singly-linked list.
  class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

// 1. 使用hashset来存储
// 2. 直接判断前后相邻的两个元素
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        // Set<Integer> set = new HashSet<>();
        // set.add(head.val);
        // ListNode pre = head,cur = pre.next;
        // while (cur != null){
        //     while (set.contains(cur.val)){
        //         cur = cur.next;
        //         if (cur == null){
        //             pre.next = null;
        //             return head;
        //         }
        //     }
        //     set.add(cur.val);
        //     // 连接
        //     pre.next = cur;
        //     pre = cur;
        //     cur = cur.next;
        // }
        // return head;
        ListNode cur = head;
        while (cur.next != null){
            // 相邻元素比较
            if (cur.val == cur.next.val){
                cur.next = cur.next.next;
            }else{
                cur = cur.next;
            }
        }
        return head;
    }
}
// @lc code=end

