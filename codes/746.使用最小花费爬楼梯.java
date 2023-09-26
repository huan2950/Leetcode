/*
 * @lc app=leetcode.cn id=746 lang=java
 *
 * [746] 使用最小花费爬楼梯
 */

// @lc code=start
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        // dp[i] is the min cost to the i th floor
        // dp[i] = min(dp[i-2] + cost[i-2], dp[i-1] + cost[i-1])
        int dp0 = 0,dp1 = 0;
        for (int i = 2;i <= cost.length; i++){
            int dpi = Math.min(dp0 + cost[i-2], dp1 + cost[i-1]);
            dp0 = dp1;
            dp1 = dpi;
        }
        return dp1;
    }
}
// @lc code=end

