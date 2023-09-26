/*
 * @lc app=leetcode.cn id=70 lang=java
 *
 * [70] 爬楼梯
 */

// @lc code=start
class Solution {
    public int climbStairs(int n) {
        // dp[i] is the way to the ith floor
        // dp[i] = dp[i-1] + dp[i-2]
        // the solution is to find dp[n]
        if (n < 3) return n;
        int[] dp = new int[]{1,2};
        for (int i = 3;i <= n;i++){
            int sum = dp[0] + dp[1];
            dp[0] = dp[1];
            dp[1] = sum;
        }
        return dp[1];
    }
}
// @lc code=end

