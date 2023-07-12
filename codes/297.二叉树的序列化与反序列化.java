/*
 * @lc app=leetcode.cn id=297 lang=java
 *
 * [297] 二叉树的序列化与反序列化
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
 *     TreeNode(int x) { val = x; }
 * }
 */


// class Codec {

//     //定义一个字符串
//     StringBuffer sb = new StringBuffer();

//     // Encodes a tree to a single string.
//     public String serialize(TreeNode root) {
//         traverse(root);
//         return sb.toString();
//     }

//     // Decodes your encoded data to tree.
//     public TreeNode deserialize(String data) {
//         String[] nodes = data.split(",");
//         LinkedList<String> list = new LinkedList<>();
//         for (String node : nodes){
//             list.addLast(node);
//         }
//         return bulidTree(list);
//     }

//     public void traverse(TreeNode root){
//         if(root == null){
//             sb.append("#,");
//             return;
//         }

//         sb.append(root.val + ",");
//         traverse(root.left);
//         traverse(root.right);
//     }

//     public TreeNode bulidTree(LinkedList<String> nodes){
//         if (nodes == null){
//             return null;
//         }

//         String rootVal = nodes.removeFirst();
//         if (rootVal.equals("#")){
//             return null;
//         }
//         TreeNode root = new TreeNode(Integer.parseInt(rootVal));
//         root.left = bulidTree(nodes);
//         root.right = bulidTree(nodes);

//         return root;
//     }
// }

class Codec {

    String SEP = ",";
    String NULL = "#";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        // 初始化队列，将 root 加入队列
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                TreeNode cur = q.poll();
                /* 层级遍历代码位置 */
                if (cur == null) {
                    sb.append(NULL).append(SEP);
                    continue;
                }
                sb.append(cur.val).append(SEP);
                /*****************/
                q.offer(cur.left);
                q.offer(cur.right);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;
        String[] nodes = data.split(SEP);
        // 第一个元素就是 root 的值
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        // 队列 q 记录父节点，将 root 加入队列
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        // index 变量记录正在序列化的节点在数组中的位置
        int index = 1;
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                TreeNode parent = q.poll();
                // 为父节点构造左侧子节点
                String left = nodes[index++];
                if (!left.equals(NULL)) {
                    parent.left = new TreeNode(Integer.parseInt(left));
                    q.offer(parent.left);
                }
                // 为父节点构造右侧子节点
                String right = nodes[index++];
                if (!right.equals(NULL)) {
                    parent.right = new TreeNode(Integer.parseInt(right));
                    q.offer(parent.right);
                }
            }
        }
        return root;
    }

}



// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
// @lc code=end

