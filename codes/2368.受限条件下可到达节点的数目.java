/*
 * @lc app=leetcode.cn id=2368 lang=java
 *
 * [2368] 受限条件下可到达节点的数目
 */
/*
 * 思路：从0号节点开始深度优先搜索，遇到受限节点就跳过
 ! 使用链表方式存储节点的边
 */
// @lc code=start

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    int count = 0;
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        // 初始化树
        List<Integer>[] nodes = new ArrayList[n];
        for(int i = 0; i < n; i++){
            nodes[i] = new ArrayList<>();
        }

        // 根据边的信息构建树
        for(int[] edge : edges){
            nodes[edge[0]].add(edge[1]);
            nodes[edge[1]].add(edge[0]);
        }
        
        // 受限节点集合
        Set<Integer> set = new HashSet<>();
        for(int node : restricted){
            set.add(node);
        }

        traverse(nodes, 0, -1, set);
        return count;
    }
    
    /**
     * 深度优先遍历，注意不能往回遍历
     * @param nodes 节点列表
     * @param cur 当前遍历的节点
     * @param pre 当前节点的父节点，防止往回遍历
     * @param restricted
     */
    public void traverse (List<Integer>[] nodes, int cur, int pre, Set<Integer> set){
        count++;
        for (int node : nodes[cur]){
            if (node != pre && !set.contains(node)){
                traverse(nodes, node, cur, set);
            }
        }
    }
}
// @lc code=end

