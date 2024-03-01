/*
 * @lc app=leetcode.cn id=235 lang=java
 *
 * [235] 二叉搜索树的最近公共祖先
 */

// @lc code=start

import utils.TreeNode;

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

    public TreeNode find(TreeNode root, TreeNode p, TreeNode q){
        if (root == null) return null;
        // 前序位置——判断当前节点是否为p或q
        if(root.val < p.val && root.val < q.val){
            return find(root.right, p, q);
        }else if(root.val > q.val && root.val > p.val){
            return find(root.left, p, q);
        }else return root;
    }
}
// @lc code=end

