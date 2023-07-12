package utils;

import java.util.ArrayList;

// @lc code=start

import java.util.LinkedList;
import java.util.List;

class Solution {

    public void bulidGraph(int numCourses, int[][] prerequisites){
        // 根据prequisites构建图——邻接表
        List<List<Integer>> graph = new ArrayList<List<Integer>>(numCourses);
        for (int i = 0; i < numCourses; i++){
            graph.add( new ArrayList<Integer>());
        }
        // List<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>(numCourses);
        for (int[] edges: prerequisites){
            graph.get(edges[1]).add(edges[0]);
        }
    }
}


public class Test {
    public static void main(String[] args) {
        // Create a new Solution instance
        Solution solution = new Solution();

        // Create a test case
        int numCourses = 2;
        int[][] prerequisites = {{1, 0},{0,1}};
        // ListNode head = ListNode.createLinkedList(vals);

        // Get the answer
        solution.bulidGraph(numCourses, prerequisites);

        // Print the answer
        // System.out.println(res);
    }
}

