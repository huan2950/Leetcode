/*
 * @lc app=leetcode.cn id=106 lang=java
 *
 * [106] 从中序与后序遍历序列构造二叉树
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

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
    private Map<Integer, Integer> indexMap = new HashMap<Integer, Integer>();
    public TreeNode buildTree( int[] inorder,int[] postorder) {
        //根据preorder数组构造hashmap中值到索引的映射
        for(int i = 0;i<inorder.length;i++){
            indexMap.put(inorder[i],i);
        }
        return build(postorder, 0, postorder.length-1, inorder, 0, postorder.length-1);
    }

    public TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder,int inStart, int inEnd){
        if(preStart>preEnd){
            return null;
        }
        //root
        int rootVal = preorder[preEnd];
        TreeNode root = new TreeNode(rootVal);
        int index = indexMap.get(rootVal);
        int leftSize = index-inStart;
        root.left = build(preorder,preStart,preStart+leftSize-1,inorder,inStart,index-1);
        root.right = build(preorder,preStart+leftSize,preEnd-1,inorder,index+1,inEnd);
        return root;
    }
}
// @lc code=end

