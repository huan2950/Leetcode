/*
 * @lc app=leetcode.cn id=785 lang=java
 *
 * [785] 判断二分图
 */

// @lc code=start
class Solution {
    // 二分染色问题,在遍历的过程中进行染色
    // !若未访问过,则涂上不同颜色
    // !若访问过,则进行比较是否符合二分图要求

    boolean[] visited;

    boolean isBipartite = true;

    boolean[] color;

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        visited = new boolean[n];
        color = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i])
                traverse(graph, i);
        }
        
        return isBipartite;
        
    }

    // DFS遍历
    public void traverse(int[][]graph, int v){
        for (int t : graph[v]) {
            if (!visited[t]){// 未访问过,则染不同颜色
                visited[t] = true;
                color[t] = !color[v];// 染不同色
                traverse(graph, t);
            }else{//访问过,则比较颜色
                if (color[t] == color[v]) {
                    isBipartite = false;// 若访问过,则比较是否符合二分图要求
                    return;
                }
            }
        }
    }
}
// @lc code=end

