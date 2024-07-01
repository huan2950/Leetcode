/*
 * @lc app=leetcode.cn id=894 lang=java
 *
 * [894] 所有可能的真二叉树
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
    public List<TreeNode> allPossibleFBT(int n) {
        return dfs(n);
    }
    public List<TreeNode> dfs(int n) {
        List<TreeNode> res = new ArrayList<>();
        if (n == 1) {
            res.add(new TreeNode(0));
            return res;
        }
        if (n % 2 == 0) {
            return res;
        }
        for (int i = 1; i < n; i += 2) {
            List<TreeNode> leftInfo = dfs(i);
            List<TreeNode> rightInfo = dfs(n - 1 - i);
            for (TreeNode l : leftInfo) {
                for (TreeNode r : rightInfo) {
                    TreeNode node = new TreeNode(0, l, r);
                    res.add(node);
                }
            }
        }
        return res;
    }
}
// @lc code=end

