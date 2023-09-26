/*
 * @lc app=leetcode.cn id=416 lang=java
 *
 * [416] 分割等和子集
 */

// @lc code=start
class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        if (n < 2) return false;
        
        int sum = 0,max = 0;
        // Sum should be even
        // max can't larger then 1/2 sum
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            max = Math.max(max,nums[i]);
        }
        if (sum%2==1) return false;
        int target = sum / 2;
        if (max > target) return false;

        boolean[][] dp = new boolean[n][target+1];
        
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = true;
        }

        dp[0][nums[0]] = true;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= target; j++) {
                if (j >= nums[i]){
                    dp[i][j] = dp[i-1][j] | dp[i-1][j-nums[i]];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n-1][target];

        
    }
}
// @lc code=end

