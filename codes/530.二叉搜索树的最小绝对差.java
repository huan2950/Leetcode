/*
 * @lc app=leetcode.cn id=530 lang=java
 *
 * [530] 二叉搜索树的最小绝对差
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
     * 思路：利用二叉搜索树的中序遍历序列递增的思路，比较相邻两个元素的差值
     */
    TreeNode pre;
    int res = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        traverse(root);
        return res;
    }

    public void traverse(TreeNode root){
        if (root == null) return;
        traverse(root.left);
        if (pre != null){
            res = Math.min(res, root.val - pre.val);
        }
        //! 关键部分：记录前驱信息，要在中序位置的末尾(也就是即将离开左子树的位置)记录前驱信息
        pre = root;
        traverse(root.right);

    }
}
// @lc code=end

