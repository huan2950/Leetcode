/*
 * @lc app=leetcode.cn id=714 lang=java
 *
 * [714] 买卖股票的最佳时机含手续费
 */

// @lc code=start
class Solution {

    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        // int[][] dp = new int[n][2];
        int dp_0 = 0,dp_1 = -prices[0];
        for (int i = 0; i < n; i++) {
            int temp = dp_0;
            dp_0 = Math.max(dp_0,dp_1 + prices[i] - fee);
            dp_1 = Math.max(dp_1,temp - prices[i]);
        }
        return dp_0;
    }
}
// @lc code=end

