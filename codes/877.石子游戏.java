/*
 * @lc app=leetcode.cn id=877 lang=java
 *
 * [877] 石子游戏
 */

// @lc code=start
class Solution {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[] dp = new int[n];//要求的是dp[0][n-1]
        
        for (int i = 0; i < dp.length; i++) {
            dp[i] = piles[i];
        }

        for (int i = n-2; i >= 0; i--) {
            for (int j = i+1; j < n; j++) {
                dp[j] = Math.max(piles[i]-dp[j],piles[j]-dp[j-1]);
            }
        }

        return dp[n-1] > 0;
    }
}
// @lc code=end

