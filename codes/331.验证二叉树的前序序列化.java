 /*
 * @lc app=leetcode.cn id=331 lang=java
 *
 * [331] 验证二叉树的前序序列化
 */

// @lc code=start
class Solution {
    int index = 0;
        public boolean isValidSerialization(String preorder) {
            String[] nodes = preorder.split(",");
            int len = nodes.length;
            return dfs(nodes, len) && index == len;
        }

        private boolean dfs(String[] nodes, int len) {
            if (index == len) return false;
            if (nodes[index++].equals("#")) return true;

            boolean left = dfs(nodes, len);
            boolean right = dfs(nodes, len);
            return left && right;
        }
}
// @lc code=end

