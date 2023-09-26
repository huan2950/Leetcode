/*
 * @lc app=leetcode.cn id=337 lang=java
 *
 * [337] 打家劫舍 III
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
    public int rob(TreeNode root) {
        int[] res = traverse(root);
        return Math.max(res[0], res[1]);
    }

    public int[] traverse(TreeNode node){
        if (node == null){
            return new int[]{0,0};
        }
        // for the dp array, dp[0] represent select the current node
        // dp[1] represent not select the current node
        int[] dpLeft = traverse(node.left);
        int[] dpRight = traverse(node.right);

        int selected = node.val + dpLeft[1] + dpRight[1];// select the current node, can't select the children node
        // not to select the current node, the maxium depends on the left and right children
        int unselected = Math.max(dpLeft[0], dpLeft[1]) + Math.max(dpRight[0], dpRight[1]);

        return new int[]{selected, unselected};
    }
}
// @lc code=end

