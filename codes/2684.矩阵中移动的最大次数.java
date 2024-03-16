/*
 * @lc app=leetcode.cn id=2684 lang=java
 *
 * [2684] 矩阵中移动的最大次数
 */
/*
 * 思路：动态规划
 * dp[i][j]表示从第一列任一点能到达矩阵grid[i][j],要求的就是dp[i][j]=1的最大的j
 * 状态转移方程：
 * dp[i][j] = (
 * 1 if dp[i-1][j-1] && grid[i-1][j-1] < grid[i][j] else 0 # 从左上角转移
 * 1 if dp[i][j-1] && grid[i][j-1] < grid[i][j] else 0   # 从左边转移
 * 1 if dp[i][j-1] && grid[i+1][j-1] < grid[i][j] else 0 # 从左下角转移
 * )
 * 三者取或的关系
 * 
 * 初始化:
 * dp[i][0] = true
 ! 最开始把题目看错了，以为是从矩阵中任意一点出发的最大步数
 ! 如果是从任意一点出发,则毫无疑问使用动态规划,dp[i][j]表示为最大步数
 ! 如果是从第一列出发，使用动态规划时不能将dp[i][j]表示为最大步数,而是要考虑到是否能从第一列出发到达
 ! 本题更好的方式是使用dfs进行搜索，这样空间复杂度还会小一点
 */
// @lc code=start
class Solution {
    public int maxMoves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] dp = new boolean[m][n];

        // dp第一列全是0,从第二列开始
        // 注意，外层应该是遍历列，内层才是遍历行
        int res = 0;
        for (int j = 0; j < n; j++){// 列
            for (int i = 0; i < m; i++){ // 行
                // 第一列
                if (j == 0){
                    dp[i][j] = true;
                    continue;
                }
                boolean leftUp, left, leftDown;
                // 左上角
                if (i == 0) leftUp = false;
                else {
                    leftUp = dp[i-1][j-1] && grid[i-1][j-1] < grid[i][j] ? true : false;
                }
                // 左边转移
                left = dp[i][j-1] && grid[i][j-1] < grid[i][j] ? true : false;

                // 左下角转移
                if (i == m - 1) leftDown = false;
                else leftDown = dp[i+1][j-1] && grid[i+1][j-1] < grid[i][j] ? true : false;

                dp[i][j] = leftUp || left || leftDown;

                if (dp[i][j]) res = Math.max(res, j);
            }
        }
        return res;
    }
}
// @lc code=end

