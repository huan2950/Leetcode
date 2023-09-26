/*
 * @lc app=leetcode.cn id=695 lang=java
 *
 * [695] 岛屿的最大面积
 */

// @lc code=start
class Solution {
    private int res;
    public int maxAreaOfIsland(int[][] grid) {
        res = 0;
        for (int i = 0; i < grid.length; i ++) {
            for (int j = 0; j < grid[0].length; j ++) {
                if (grid[i][j] == 1) {
                    int area = traverse(grid, i, j);
                    res = Math.max(res, area);
                }
            }
        }
        return res;
    }

    public int traverse(int[][] grid, int i, int j) {
        // Reach the boundary, just return
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length)
            return 0;
        // If it is not an island, just return
        if (grid[i][j] != 1){
            return 0;
        }
        // Visit the island and mark it as visited
        grid[i][j] = 2;
        // Traverse the islands around the current island
        return 1
        + traverse(grid, i - 1, j)
        + traverse(grid, i + 1, j)
        + traverse(grid, i, j - 1)
        + traverse(grid, i, j + 1);
    }
}
// @lc code=end

