/*
 * @lc app=leetcode.cn id=654 lang=java
 *
 * [654] 最大二叉树
 */

// @lc code=start
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
import utils.TreeNode;

class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length-1);
    }

    // 找到一个数组中最大值以及对应的索引
    public int findMax(int[] nums,int low,int high){
        int max = nums[low];
        int index = low;
        for(int i = low;i<=high;i++){
            if(nums[i]>max){
                max = nums[i];
                index = i;
            }
        }
        return index;
    }

    //递归创建二叉树
    public TreeNode build(int[] nums,int low,int high){
        if(low>high){
            return null;
        }
        int index = findMax(nums,low,high);
        TreeNode root = new TreeNode(nums[index]);
        root.left = build(nums,low,index-1);
        root.right = build(nums,index+1,high);
        return root;
    }
}
// @lc code=end

