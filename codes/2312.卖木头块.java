/*
 * @lc app=leetcode.cn id=2312 lang=java
 *
 * [2312] 卖木头块
 */
/*
 * 思路：动态规划
 * dp[i][j]为高为i，宽为j的最多钱数，最终要求的就是dp[m][n]
 * 状态转移： 
 * (1)横向切割：dp[i][j] = max(dp[i][j], dp[k][j] + dp[i-k][j]) k∈[1,i/2]
 * (2)纵向切割：dp[i][j] = max(dp[i][j], dp[i][k] + dp[i][j-k]) k∈[1,j/2]
 * 初始化：dp[i][0] = 0 dp[0][j] = 0, dp[h][w] = price
 */
// @lc code=start
class Solution {
    public long sellingWood(int m, int n, int[][] prices) {
        long[][] dp = new long [m + 1][n + 1];
        // 初始化
        for (int i = 0; i < prices.length; i++){
            dp[prices[i][0]][prices[i][1]] = prices[i][2];
        }
        // 状态转移
        for (int i = 1; i <= m; i++){
            for (int j = 1; j <= n; j++){
                // 横向切割
                for (int k = 1; k <= i / 2; k++){
                    dp[i][j] = Math.max(dp[i][j], dp[k][j] + dp[i - k][j]);
                }
                // 纵向切割
                for (int k = 1; k <= j / 2; k++){
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[i][j - k]);
                }
            }
        }
        return dp[m][n];
    }
}
// @lc code=end

