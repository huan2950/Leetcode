/*
 * @lc app=leetcode.cn id=429 lang=java
 *
 * [429] N 叉树的层序遍历
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> level = new LinkedList<>();
            for (int i = 0; i < size; i++){
                Node node = queue.poll();
                level.add(node.val);
                for (Node child : node.children){
                    queue.offer(child);
                }
                // if (node.left != null){
                //     queue.offer(node.left);
                // }
                // if (node.right != null){
                //     queue.offer(node.right);
                // }
            }
            res.add(level);
        }
        return res;
    }
}
// @lc code=end

