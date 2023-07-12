/*
 * @lc app=leetcode.cn id=1584 lang=java
 *
 * [1584] 连接所有点的最小费用
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;

        List<int[]> edges = new ArrayList<int[]>();

        // 计算所有的边的权重
        for (int i = 0; i < n; i++){
            for (int j = i+1; j < n; j++){
                edges.add(new int[]{i, j, Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1])});
            }
        }

        // 按照权重排序
        edges.sort((edge1, edge2) -> edge1[2] - edge2[2]);

        int cost = 0;

        UF uf = new UF(n);

        for(int[] edge: edges){
            int x = edge[0];
            int y = edge[1];
            int weight = edge[2];

            if (!uf.connected(x, y)){// 若不连通,则合并
                uf.union(x, y);
                cost += weight;
            }
        }

        return cost;

    }
}

class UF {
    // 连通分量个数
    private int count;
    // 存储每个节点的父节点
    private int[] parent;

    // n 为图中节点的个数
    public UF(int n) {
        this.count = n;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }
    
    // 将节点 p 和节点 q 连通
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        
        if (rootP == rootQ)
            return;
        
        parent[rootQ] = rootP;
        // 两个连通分量合并成一个连通分量
        count--;
    }

    // 判断节点 p 和节点 q 是否连通
    public boolean connected(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        return rootP == rootQ;
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    // 返回图中的连通分量个数
    public int count() {
        return count;
    }
}
// @lc code=end

