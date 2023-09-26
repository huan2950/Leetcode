/*
 * @lc app=leetcode.cn id=100 lang=java
 *
 * [100] 相同的树
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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return traverse(p, q);
    }

    public boolean traverse(TreeNode left, TreeNode right){
        if (left == null && right == null) return true; // both are null
        if (left == null || right == null) return false; // one is null, the other is not null
        if (left.val != right.val) return false; // both are not null, but the values are different
        return traverse(left.left, right.left) && traverse(left.right, right.right);
    }
}
// @lc code=end

