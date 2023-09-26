/*
 * @lc app=leetcode.cn id=110 lang=java
 *
 * [110] 平衡二叉树
 */

// @lc code=start

import utils.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        return traverse(root) != -1;
    }

    public int traverse(TreeNode root){
        if (root == null) return 0;
        int left = traverse (root.left);
        int right = traverse (root.right);

        if (left == -1 || right == -1 || Math.abs(left - right) > 1) return -1;
        else return Math.max(left, right) + 1;
    } 
}
// @lc code=end

