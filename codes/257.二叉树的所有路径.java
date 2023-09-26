/*
 * @lc app=leetcode.cn id=257 lang=java
 *
 * [257] 二叉树的所有路径
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
    List<String> res = new ArrayList<String>();
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return res;
        StringBuffer path = new StringBuffer();
        traverse(root, path);
        return res;
    }


    public void traverse(TreeNode root, StringBuffer path){
        if (root == null) return;
        // leave node
        if (root.left == null && root.right == null){
            res.add(path.toString() + root.val);
            return;
        }

        int size = path.length();
        path.append(root.val + "->");
        traverse(root.left, path);
        traverse(root.right, path);
        path.delete(size, path.length());

    }
}
// @lc code=end

