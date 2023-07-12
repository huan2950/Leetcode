/*
 * @lc app=leetcode.cn id=886 lang=java
 *
 * [886] 可能的二分法
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {

    boolean[] visited;

    boolean isBipartite = true;

    boolean[] color;

    public boolean possibleBipartition(int n, int[][] dislikes) {
        visited = new boolean[n];
        color = new boolean[n];

        List<List<Integer>> graph = bulidGraph(n, dislikes);

        for (int i = 0; i < n; i++) {
            if (!visited[i])
                traverse(graph, i);
        }
        
        return isBipartite;
    }

    // DFS遍历
    public void traverse(List<List<Integer>> graph, int v){
        for (int t : graph.get(v)) {
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

    public List<List<Integer>> bulidGraph(int n,int[][] dislikes){
        List<List<Integer>> graph = new ArrayList<List<Integer>>(n);
        for (int i = 0; i < n; i++){
            graph.add( new ArrayList<Integer>());
        }
        for (int[] edges: dislikes){
            graph.get(edges[0]-1).add(edges[1]-1);
            graph.get(edges[1]-1).add(edges[0]-1);
        }
        return graph;
    }
}
// @lc code=end

