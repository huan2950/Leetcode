/*
 * @lc app=leetcode.cn id=1020 lang=java
 *
 * [1020] 飞地的数量
 */

// @lc code=start
class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        //Excluding the island on the side is a closed island.
        // Start from the first line
        for (int j = 0; j < n; j ++) {
            traverse(grid, 0, j);
        }
        // Start from the last line 
        for (int j = 0; j < n; j ++) {
            traverse(grid, m - 1, j);
        }
        // Start from the first column
        for (int i = 0; i < m; i ++) {
            traverse(grid, i, 0);
        }
        // Start from the last column
        for (int i = 0; i < m; i ++) {
            traverse(grid, i, n - 1);
        }

        // Traversing other islands, the result is the number of closed islands.
        int res = 0;
        for (int i = 1; i < m - 1; i ++) {
            for (int j = 1; j < n - 1; j ++) {
                if (grid[i][j] == 1) {
                    // traverse(grid, i, j);
                    res ++;
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

