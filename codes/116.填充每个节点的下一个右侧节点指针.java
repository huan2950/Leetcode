/*
 * @lc app=leetcode.cn id=116 lang=java
 *
 * [116] 填充每个节点的下一个右侧节点指针
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

class Solution {
    public Node connect(Node root) {
        if(root == null){
            return root;
        }
        Node leftmost = root;
        // ! 如果当前leftmost在第K层，则循环中是对第k+1层的节点建立next关系
        // ! 所以是对leftmost.left进行判空操作
        while(leftmost.left != null){ 
            Node head = leftmost;
            while(head != null){
                //同一个父节点，直接建立next关系
                head.left.next = head.right;
                if (head.next != null){
                    // 不同的父节点,则利用相邻的父节点建立子节点的next关系
                    head.right.next = head.next.left;
                }
                head = head.next;
            }
            leftmost = leftmost.left;
        }
        return root;
    }
}
// @lc code=end

