/*
 * @lc app=leetcode.cn id=797 lang=java
 *
 * [797] 所有可能的路径
 */

// @lc code=start

import java.util.LinkedList;
import java.util.List;

class Solution {

    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        LinkedList<Integer> path = new LinkedList<>();
        traverse(graph, 0, path);
        return res;
    }

    //遍历图框架
    public void traverse(int[][] graph,int start,LinkedList<Integer> path){
        path.add(start);
        // 找到最终节点
        if (start == graph.length - 1){
            res.add(new LinkedList<>(path));
            path.removeLast();
            return;
        }
        // 访问节点
        for (int i: graph[start]){
            traverse(graph, i, path);
        }
        // 退出节点
        path.removeLast();
    }
}
// @lc code=end

