/*
 * @lc app=leetcode.cn id=111 lang=java
 *
 * [111] 二叉树的最小深度
 */

// @lc code=start

//  Definition for a binary tree node.

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }

// class Solution {
//     public int minDepth(TreeNode root) {
//         //BFS
//         if (root  == null) return 0;
//         Queue<TreeNode> q = new LinkedList<>();
//         q.offer(root);
//         int depth = 1;

//         while (!q.isEmpty()) {
//             int size = q.size();
//             for (int i = 0; i < size; i++) {
//                 TreeNode cur = q.poll();
//                 if(cur.left == null && cur.right == null){
//                     return depth;
//                 }
//                 if (cur.left != null) {
//                     q.offer(cur.left);
//                 }
//                 if (cur.right != null){
//                     q.offer(cur.right);
//                 }
//             }
//             depth++;
//         }
//         return depth;
//     }
// }

class Solution {
    /*
     * 思路： 前序遍历,对于一个节点，它的最小深度取决于左子树和右子树的最小深度
     * 依次遍历左右子树求最小深度
     */
    public int minDepth(TreeNode root) {
        // 递归返回条件
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            return 1;
        }
        int ans = Integer.MAX_VALUE;
        if(root.left != null) {// 左子树为空，右子树不为空，那么最小深度应该是1+左子树的深度
            ans = Math.min(minDepth(root.left), ans);
        }
        if(root.right != null) {
            ans = Math.min(minDepth(root.right), ans);
        }
        return ans + 1;
    }
}
// @lc code=end

