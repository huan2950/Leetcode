/*
 * @lc app=leetcode.cn id=310 lang=java
 *
 * [310] 最小高度树
 */

// @lc code=start
/*
 * 思路：拓扑排序
 * 从叶子节点开始剥离整个图，然后逐步剥离叶子节点，直到最后出现的节点
 * 利用拓扑排序，从外向内剥离叶子节点，当我们到达最后一层的时候，剩下的节点就可作为最小高度树的根节点
 * 
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        // 只有一个节点
        if (n == 1){
            res.add(0);
            return res;
        }
        // 建立节点之间的关系
        List<List<Integer>> nodes = new ArrayList<>();
        // 记录节点的度
        int[] degree = new int[n];
        for (int i = 0; i < n; i++){
            nodes.add(new ArrayList<>());
        }

        for (int[] edge: edges){
            nodes.get(edge[0]).add(edge[1]);
            nodes.get(edge[1]).add(edge[0]);
            degree[edge[0]]++;
            degree[edge[1]]++;
        }

        // 拓扑排序
        Queue<Integer> queue = new LinkedList<>();
        // 初始化队列，将度为1的节点(叶子节点)加入队列中
        for(int i = 0; i < n; i++){
            if (degree[i] == 1) queue.offer(i);
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            // 保存最后一次的叶子节点作为结果集
            res = new ArrayList<>();
            for (int i = 0; i < size; i++){
                int cur = queue.poll();
                res.add(cur);
                for (int node: nodes.get(cur)){
                    //当前出队(叶子)节点的相邻节点度减一
                    degree[node]--;
                    if (degree[node] == 1) queue.offer(node);
                }
            }
        }
        // 循环结束过后，最后一次保留叶子节点就是结果集
        return res;
    }
}
// @lc code=end

