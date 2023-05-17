/*
 * @lc app=leetcode.cn id=312 lang=java
 *
 * [312] 戳气球
 */

// @lc code=start
class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] points = new int[n+2];
        points[0] = points[n+1] = 1;
        for(int i = 1;i <=n; i++){
            points[i] = nums[i-1];
        }

        int[][] dp = new int[n+2][n+2];//要求dp[0][n+1]
        
        for (int i = n; i >= 0; i--) {//从下往上
            for (int j = i+1; j <= n+1; j++) {
                int max = 0;
                for (int k = i+1; k < j; k++) {
                    max = Math.max(max, dp[i][k] + dp[k][j] + points[i] * points[k] * points[j]);
                }
                dp[i][j] = max;
            }
        }
        return dp[0][n+1];
    }
}
// @lc code=end

