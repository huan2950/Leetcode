import java.util.Stack;

/*
 * @lc app=leetcode.cn id=112 lang=java
 *
 * [112] 路径总和
 */

// @lc code=start

//  Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

// class Solution {
//     public boolean hasPathSum(TreeNode root, int targetSum) {
//         if (root == null) return false;
//         Stack<TreeNode> stackNode = new Stack<TreeNode>();
//         Stack<Integer> stackSum = new Stack<Integer>();
//         //根节点入栈
//         stackNode.push(root);
//         stackSum.push(root.val);
//         while (!stackNode.isEmpty()) {
//             TreeNode nodeOut = stackNode.pop();
//             int sumOut = stackSum.pop();
//             //叶子结点
//             if (nodeOut.left == null && nodeOut.right == null) {
//                 if (sumOut == targetSum) {
//                     return true;
//                 }
//                 continue;
//             }//非叶子子结点入栈
//             if (nodeOut.left != null){
//                 stackNode.push(nodeOut.left);
//                 stackSum.push(sumOut+nodeOut.left.val);
//             }
//             if (nodeOut.right != null){
//                 stackNode.push(nodeOut.right);
//                 stackSum.push(sumOut+nodeOut.right.val);
//             }
//         }
//         return false;
//     }
// }

class Solution{
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null)return false;
        if(root.left==null&&root.right==null)return root.val==targetSum;
        return hasPathSum(root.left,targetSum-root.val) || hasPathSum(root.right,targetSum-root.val);
    }


    // public boolean hasPathSum(TreeNode root, int targetSum) {

    // }

    // public boolean backtrack(TreeNode root, int sum,int target){
    //     if (root == null) return false;
    //     if (root.left == null  && root.right == null && sum == target)return true;
        
    //     if (root.left != null){

    //     }
    // }    
}
// @lc code=end

