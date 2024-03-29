/*
 * @lc app=leetcode.cn id=222 lang=java
 *
 * [222] 完全二叉树的节点个数
 */

// @lc code=start

// import utils.TreeNode;

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
    public int countNodes(TreeNode root) {
        //完全二叉树介于普通二叉树和满二叉树之间
        // ! 找到左子树和右子树的高度
        TreeNode left = root, right = root;
        int leftHeight = 0, rightHeight = 0;
        while(left != null){
            left = left.left;
            leftHeight++;
        }
        while(right != null){
            right = right.right;
            rightHeight++;
        }

        if (leftHeight == rightHeight) return (int)Math.pow(2, leftHeight) - 1;//满二叉树

        else return 1 + countNodes(root.left) + countNodes(root.right);//普通二叉树
    }
}
// @lc code=end

