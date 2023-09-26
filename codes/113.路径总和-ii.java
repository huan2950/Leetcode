/*
 * @lc app=leetcode.cn id=113 lang=java
 *
 * [113] 路径总和 II
 */

// @lc code=start

import java.util.ArrayList;
import java.util.LinkedList;
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
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) return res;
        List<Integer> path = new LinkedList<Integer>();
        traverse(root, targetSum, path);
        return res;
    }

    public void traverse(TreeNode root, int targetSum, List<Integer> path){
        path.add(root.val);
        if (root.left == null && root.right == null){
            // leaf node
            if (targetSum - root.val == 0) {
                // ! Warning: can't just pass the path to the result,because 
                // ! path will change later
                // ! the correct is new a object and pass the new object to the result
                res.add(new ArrayList<>(path));
            }
            return;
        }

        if (root.left != null){
            traverse(root.left, targetSum - root.val, path);// go to the next level
            path.remove(path.size() - 1);   // backtrack
        }

        if (root.right != null){
            traverse(root.right, targetSum - root.val, path); // go to the next level
            path.remove(path.size() - 1);
        }
    }
}
// @lc code=end

