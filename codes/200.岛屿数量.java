/*
 * @lc app=leetcode.cn id=200 lang=java
 *
 * [200] 岛屿数量
 */

// @lc code=start

class Solution {
    private int res;
    public int maxAreaOfIsland(char[][] grid) {
        res = 0;
        for (int i = 0; i < grid.length; i ++) {
            for (int j = 0; j < grid[0].length; j ++) {
                if (grid[i][j] == '1') {
                    traverse(grid, i, j);
                    res ++;
                }
            }
        }
        return res;
    }

    public void traverse(char[][] grid, int i, int j) {
        // Reach the boundary, just return
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length)
            return;
        // If it is not an island, just return
        if (grid[i][j] != '1'){
            return;
        }
        // Visit the island and mark it as visited
        grid[i][j] = '2';
        // Traverse the islands around the current island
        traverse(grid, i - 1, j);
        traverse(grid, i + 1, j);
        traverse(grid, i, j - 1);
        traverse(grid, i, j + 1);
    }
}
// @lc code=end

