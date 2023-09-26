/*
 * @lc app=leetcode.cn id=309 lang=java
 *
 * [309] 最佳买卖股票时机含冷冻期
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        // base case
        dp[0][1] = -prices[0];
        for(int i = 1; i < n; i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], ( (i - 2) < 0 ? 0 : dp[i-2][0] ) - prices[i]);
        }
        return dp[n-1][0];
    }
}
// @lc code=end

