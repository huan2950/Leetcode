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

class Solution {
    public int minDepth(TreeNode root) {
        //BFS
        if (root  == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int depth = 1;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                if(cur.left == null && cur.right == null){
                    return depth;
                }
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null){
                    q.offer(cur.right);
                }
            }
            depth++;
        }
        return depth;
    }
}
// @lc code=end

// class Solution {
//     public int minDepth(TreeNode root) {
//         if(root == null) {
//             return 0;
//         }
//         if(root.left == null && root.right == null) {
//             return 1;
//         }
//         int ans = Integer.MAX_VALUE;
//         if(root.left != null) {
//             ans = Math.min(minDepth(root.left), ans);
//         }
//         if(root.right != null) {
//             ans = Math.min(minDepth(root.right), ans);
//         }
//         return ans + 1;
//     }
// }