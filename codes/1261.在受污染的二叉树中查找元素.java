/*
 * @lc app=leetcode.cn id=1261 lang=java
 *
 * [1261] 在受污染的二叉树中查找元素
 */

// @lc code=start
/*
 * 思路：深度遍历的过程中
 */
import java.util.HashSet;
import java.util.Set;

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
class FindElements {

    private Set<Integer> set;

    public FindElements(TreeNode root) {
        this.set = new HashSet<>();
        traverse(root, 0);
    }
    
    public boolean find(int target) {
        return set.contains(target);
    }

    private void traverse(TreeNode root, int val){
        if (root == null) return;
        root.val = val;
        set.add(val);
        traverse(root.left, 2 * val + 1);
        traverse(root.right, 2 * val + 2);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */
// @lc code=end

