/*
 * @lc app=leetcode.cn id=343 lang=java
 *
 * [343] 整数拆分
 */

// @lc code=start
class Solution {
    public int integerBreak(int n) {
        // dp[i] is the maximum product after splitting i
        // dp[i] = max(max(i * (i-j), i * dp[i-j]))
        
        int[] dp = new int[n+1];
        // base case
        dp[2] = 1;
        for (int i = 3; i <= n; i++){
            int max = 0;
            for (int j = 0; j <= i/2 ; j++){
                max = Math.max(max,Math.max(j * (i-j), j * dp[i-j])); 
            }
            dp[i] = max;
        }
        return dp[n];
    }
}
// @lc code=end

