/*
 * @lc app=leetcode.cn id=518 lang=java
 *
 * [518] 零钱兑换 II
 */

// @lc code=start
class Solution {
    public int change(int amount, int[] coins) {
        // int n = coins.length;
        //二维DP数组
        // int[][] dp = new int[n+1][amount+1];
        // for (int i = 0; i <= n; i++) {
        //     dp[i][0] = 1;
        // }

        // for (int i = 1; i <= n; i++) {
        //     for (int j = 0; j <= amount; j++) {
        //         if(j >= coins[i-1]){
        //             dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
        //         }else{
        //             dp[i][j] = dp[i-1][j];
        //         }
        //     }
        // }
        // return dp[n][amount];

        //一维DP数组优化
        // dp[j] = dp[j] dp[j-coin[i-1]]
        int[] dp = new int[amount+1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int i = 0; i <= amount; i++) {
                if (i >= coin){
                    dp[i] = dp[i] + dp[i - coin];
                }
            }
        }
        return dp[amount];
    }
}
// @lc code=end

