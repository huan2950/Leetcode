/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

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

    // 存储 inorder 中值到索引的映射
    private Map<Integer, Integer> indexMap = new HashMap<Integer, Integer>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //根据preorder数组构造hashmap中值到索引的映射
        for(int i = 0;i<inorder.length;i++){
            indexMap.put(inorder[i],i);
        }
        return build(preorder, 0, preorder.length-1, inorder, 0, preorder.length-1);
    }

    public TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder,int inStart, int inEnd){
        if(preStart>preEnd){
            return null;
        }
        //root
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        int index = indexMap.get(rootVal);
        int leftSize = index-inStart;
        root.left = build(preorder,preStart+1,preStart+leftSize,inorder,inStart,index-1);
        root.right = build(preorder,preStart+leftSize+1,preEnd,inorder,index+1,inEnd);
        return root;
    }
}
// @lc code=end

