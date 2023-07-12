/*
 * @lc app=leetcode.cn id=207 lang=java
 *
 * [207] 课程表
 */

// @lc code=start

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {

    boolean[] visited;
    boolean[] onPath;
    boolean hasCycle = false;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];
        List<List<Integer>> graph = bulidGraph(numCourses, prerequisites);

        for (int i = 0; i < numCourses; i++){
            traverse(graph, i);
        }

        return !hasCycle;
    }

    // 根据prequisites题目信息构建图——邻接表
    public List<List<Integer>> bulidGraph(int numCourses, int[][] prerequisites){
        List<List<Integer>> graph = new ArrayList<List<Integer>>(numCourses);
        for (int i = 0; i < numCourses; i++){
            graph.add( new ArrayList<Integer>());
        }
        for (int[] edges: prerequisites){
            graph.get(edges[1]).add(edges[0]);
        }
        return graph;
    }

    //遍历图框架
    public void traverse(List<List<Integer>> graph,int start){

        if(onPath[start]){
            hasCycle = true;
        }


        if (visited[start] || hasCycle){
            return;
        }
        // 访问节点
        visited[start] = true;
        onPath[start] = true;
        // 进入节点
        for (int i: graph.get(start)){
            traverse(graph, i);
        }
        // 退出节点
        onPath[start] = false;
    }
}
// @lc code=end

