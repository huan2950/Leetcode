/*
 * @lc app=leetcode.cn id=236 lang=java
 *
 * [236] 二叉树的最近公共祖先
 */

// @lc code=start

// import utils.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return find(root, p, q);
    }
    // 要分清只有三种情况
    // 1. p和q分布在左子树和右子树中
    // 2. p和q分布在同一个子树中 
    //      2.1 p是q的子树
    //      3.1 q是p的子树
    //! 在递归中就是要找到节点p和q的位置，然后根据位置判断
    public TreeNode find(TreeNode root, TreeNode p, TreeNode q){
        if (root == null) return null;
        // 前序位置——判断当前节点是否为p或q
        if (root == p || root == q) return root;
        TreeNode left = find(root.left, p, q);
        TreeNode right = find(root.right, p, q);
        // 后序位置——判断当前节点的左右子树是否包含p或q
        if (left != null && right != null) return root;// 左右子树同时不为空,即p和q分布在左子树和右子树中
        return left != null ? left : right; // 对应p或者q是另一个节点的子树的情况(也就是在同一棵子树中)
    }
}
// @lc code=end

