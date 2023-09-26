/*
 * @lc app=leetcode.cn id=404 lang=java
 *
 * [404] 左叶子之和
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
    int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
       traverse(root); 
       return sum;
    }

    public void traverse(TreeNode root){
        if (root == null) return;
        if (root.left != null ){
            // not leaf node
            if (root.left.left == null && root.left.right == null){
                // left leaf node
                sum += root.left.val;
            }
        }
        traverse(root.left);
        traverse(root.right);
    }
}
// @lc code=end

