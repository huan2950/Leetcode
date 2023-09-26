/*
 * @lc app=leetcode.cn id=1905 lang=java
 *
 * [1905] 统计子岛屿
 */

// @lc code=start
class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        // traverse grid2 ,If it is island in grid2 and water in grid1, it must not be a sub-island.
        for (int i = 0; i < grid1.length; i++) {
            for (int j = 0; j < grid1[0].length; j++) {
                if (grid1[i][j] == 0 && grid2[i][j] == 1) {
                    traverse(grid2, i, j);
                }
            }
        }
        // The rest are sub-islands.
        int res = 0;
        for (int i = 0; i < grid1.length; i++) {
            for (int j = 0; j < grid1[0].length; j++) {
                if (grid2[i][j] == 1) {
                    traverse(grid2, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    public void traverse(int[][] grid, int i, int j) {
        // Reach the boundary, just return
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length)
            return;
        // If it is not an island, just return
        if (grid[i][j] != 1){
            return;
        }
        // Visit the island and mark it as visited
        grid[i][j] = 2;
        // Traverse the islands around the current island
        traverse(grid, i - 1, j);
        traverse(grid, i + 1, j);
        traverse(grid, i, j - 1);
        traverse(grid, i, j + 1);
    }
}
// @lc code=end

