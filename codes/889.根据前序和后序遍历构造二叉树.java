/*
 * @lc app=leetcode.cn id=889 lang=java
 *
 * [889] 根据前序和后序遍历构造二叉树
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
    //使用HashMap根据数组中的值存储数组中的索引
    private Map<Integer, Integer> indexMap = new HashMap<Integer, Integer>();

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        //根据preorder数组构造hashmap中值到索引的映射
        for(int i = 0;i<postorder.length;i++){
            indexMap.put(postorder[i],i);
        }
        return build(preorder, 0, preorder.length-1, postorder, 0, preorder.length-1);
    }

    public TreeNode build(int[] preorder, int preStart, int preEnd, int[] postorder,int postStart, int postEnd){
        if(preStart>preEnd){
            return null;
        }

        if(preStart == preEnd){
            return new TreeNode(preorder[preStart]);
        }

        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        int index = indexMap.get(preorder[preStart+1]);
        int leftSize = index-postStart+1;
        root.left = build(preorder,preStart+1,preStart+leftSize,postorder,postStart,index);
        root.right = build(preorder,preStart+leftSize+1,preEnd,postorder,index+1,postEnd-1);
        return root;
    }
}
// @lc code=end

