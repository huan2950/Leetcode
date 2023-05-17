/*
 * @lc app=leetcode.cn id=64 lang=java
 *
 * [64] 最小路径和
 */

// @lc code=start
class Solution {
    //优化后
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[] dp = new int[col];

        dp[0]=grid[0][0];
        //第一行
        for (int j = 1; j < col; j++) {
            dp[j] = dp[j-1] + grid[0][j];
        }

        for (int i = 1; i < row; i++) {
            dp[0] = dp[0] + grid[i][0];//第一列，在每一行循环完之后初始化
            for (int j = 1; j < col; j++) {
                dp[j] = Math.min(dp[j], dp[j-1]) + grid[i][j];
            }
        }

        return dp[col-1];
    }
}
// @lc code=end

//优化前
// class Solution {
//     public int minPathSum(int[][] grid) {
//         int row = grid.length;
//         int col = grid[0].length;
//         int[][] dp = new int[row][col];

//         dp[0][0]=grid[0][0];
//         //第一列
//         for (int i = 1; i < row; i++) {
//             dp[i][0] = dp[i-1][0] + grid[i][0];
//         }
//         //第一行
//         for (int j = 1; j < col; j++) {
//             dp[0][j] = dp[0][j-1] + grid[0][j];
//         }

//         for (int i = 1; i < row; i++) {
//             for (int j = 1; j < col; j++) {
//                 dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
//             }
//         }

//         return dp[row-1][col-1];
//     }
// }