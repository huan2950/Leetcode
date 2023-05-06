/*
 * @lc app=leetcode.cn id=104 lang=java
 *
 * [104] 二叉树的最大深度
 */

// @lc code=start

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    int depth = 0;
    int res = 0;

    public int maxDepth(TreeNode root) {
        traverse(root);
        return res;
    }

    void traverse(TreeNode root){
        if (root == null) return;

        depth++;//更新深度
        if(root.left == null && root.right == null){
            res = Math.max(depth, res);//到达叶子结点就更新一次最大深度
        }
        traverse(root.left);
        traverse(root.right);
        depth--;//回溯，depth减一
    }
}
// @lc code=end

