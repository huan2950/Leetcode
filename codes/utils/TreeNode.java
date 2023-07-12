package utils;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class BinaryTree {

    String SEP = ",";
    String NULL = "#";

    // 根据前序遍历的结果构建二叉树
    public TreeNode bulid(String data) {
        LinkedList<String> list = new LinkedList<>();
        for (String node : data.split(",")){
            list.addLast(node);
        }
        return bulidTree(list);
    }

    public TreeNode bulidTree(LinkedList<String> nodes){
        if (nodes == null){
            return null;
        }

        String rootVal = nodes.removeFirst();
        if (rootVal.equals("#")){
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(rootVal));
        root.left = bulidTree(nodes);
        root.right = bulidTree(nodes);

        return root;
    }

    public TreeNode bulid_1(String data) {
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