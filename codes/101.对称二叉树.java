/*
 * @lc app=leetcode.cn id=101 lang=java
 *
 * [101] 对称二叉树
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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true; // empty tree is symmetric
        return traverse(root.left, root.right);
    }

    public boolean traverse(TreeNode left, TreeNode right){
        if (left == null && right == null) return true; // both are null
        if (left == null || right == null) return false; // one is null, the other is not null
        if (left.val != right.val) return false; // both are not null, but the values are different
        return traverse(left.left, right.right) && traverse(left.right, right.left);
    }
}
// @lc code=end

