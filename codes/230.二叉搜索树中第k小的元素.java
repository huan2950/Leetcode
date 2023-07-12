/*
 * @lc app=leetcode.cn id=230 lang=java
 *
 * [230] 二叉搜索树中第K小的元素
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
    int count = 0;
    int res = 0;//结果
    public int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return res;
    }

    //中序遍历二叉树
    public void traverse(TreeNode root,int k){
        if (root == null) return;
        traverse(root.left,k);
        // 中序遍历代码位置
        count++;
        if (count == k){
            res = root.val;
            return;
        }
        traverse(root.right,k);
    }
}
// @lc code=end

