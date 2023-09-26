/*
 * @lc app=leetcode.cn id=188 lang=java
 *
 * [188] 买卖股票的最佳时机 IV
 */

// @lc code=start
class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        k = Math.min(k, n/2);
        int[][] dp = new int[k+1][2];
        // base case
        for (int i = 0; i <= k; i++){
            dp[i][1] = -prices[0];
        }
        for (int i = 1; i < n; i++){
            for (int j = k; j > 0; j--){
                dp[j][0] = Math.max(dp[j][0],dp[j][1] + prices[i]);
                dp[j][1] = Math.max(dp[j][1], dp[j-1][0] - prices[i]);
            }
        }
        return dp[k][0];
    }
}


// @lc code=end

