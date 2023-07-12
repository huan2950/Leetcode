/*
 * @lc app=leetcode.cn id=95 lang=java
 *
 * [95] 不同的二叉搜索树 II
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

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
    public List<TreeNode> generateTrees(int n) {
            if(n == 0)return new ArrayList<>();
            return bulidTrees(1, n);
    }

    public List<TreeNode> bulidTrees(int low, int high){
        List<TreeNode> list = new ArrayList<>();
        if(low > high){
            list.add(null);
            return list;
        }

        for (int i = low; i <= high; i++) {
            List<TreeNode> leftTrees = bulidTrees(low, i-1);//左子树的根节点列表
            List<TreeNode> rightTrees = bulidTrees(i+1, high);//右子树的根节点列表
            for (TreeNode leftTree : leftTrees) {
                for (TreeNode rightTree : rightTrees) {// 从左子树和右子树列表中选择一个与根节点组成一棵树
                    TreeNode root = new TreeNode(i);
                    root.left = leftTree;
                    root.right = rightTree;
                    list.add(root);
                }
            }
        }
        return list;
    }
}
// @lc code=end

