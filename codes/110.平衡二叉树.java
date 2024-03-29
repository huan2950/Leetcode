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
    /*
     * 后序遍历，先获取左右子树的高度，再判断
     *  -1 表示已经不是平衡二叉树了，否则返回值是以该节点为根节点树的高度
     */
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

