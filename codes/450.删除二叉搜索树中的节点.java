/*
 * @lc app=leetcode.cn id=450 lang=java
 *
 * [450] 删除二叉搜索树中的节点
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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;

        if (root.val == key){
            // todo: 删除节点
            // !三种情况: 1.左右子树都为空 2.一个子树为空 3.左右子树都不为空

            // case1 + case2
            if (root.left == null)return root.right;
            if (root.right == null)return root.left;

            // case3
            TreeNode curNode = root.right;
            while(curNode.left != null){
                curNode = curNode.left;
            }
            root.right = deleteNode(root.right, curNode.val);
            
            curNode.left = root.left;// 将左子树接到右子树的最左节点的左子树上
            curNode.right = root.right;// 将右子树接到右子树的最左节点的右子树上
            root = curNode;
        }
        else if(root.val < key){
            root.right = deleteNode(root.right, key);
        }
        else if(root.val > key){
            root.left = deleteNode(root.left, key);
        }
        return root;
    }
}
// @lc code=end

