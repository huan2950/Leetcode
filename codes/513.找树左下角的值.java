/*
 * @lc app=leetcode.cn id=513 lang=java
 *
 * [513] 找树左下角的值
 */

// @lc code=start

import java.util.LinkedList;
import java.util.Queue;

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
// class Solution {
//     public int findBottomLeftValue(TreeNode root) {
//         return levelTraverse(root);
//     }

//     public int levelTraverse(TreeNode root){
//         Queue<TreeNode> queue = new LinkedList<>();
//         queue.offer(root);

//         int leftmost = 0;
//         while (!queue.isEmpty()){
//             int size = queue.size();
//             for (int i = 0; i < size; i++){
//                 TreeNode node = queue.poll();
//                 leftmost = i == 0 ? node.val : leftmost;
//                 if (node.left != null){
//                     queue.offer(node.left);
//                 }
//                 if (node.right != null){
//                     queue.offer(node.right);
//                 }
//             }
//         }
//         return leftmost;

//     }
// }
class Solution {
// 思路：前序遍历，遍历到叶子节点就记录一下深度，返回深度最大的叶子节点值
    private int Deep = -1;
    private int value = 0;
    public int findBottomLeftValue(TreeNode root) {
        value = root.val;
        findLeftValue(root,0);
        return value;
    }

    private void findLeftValue (TreeNode root,int deep) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            if (deep > Deep) {
                value = root.val;
                Deep = deep;
            }
        }
        if (root.left != null) findLeftValue(root.left,deep + 1);
        if (root.right != null) findLeftValue(root.right,deep + 1);
    }
}
// @lc code=end

