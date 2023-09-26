/*
 * @lc app=leetcode.cn id=674 lang=java
 *
 * [674] 最长连续递增序列
 */

// @lc code=start


class Solution {
    public int findLengthOfLCIS(int[] nums) {
        // int[] dp = new int[nums.length];
        // Arrays.fill(dp, 1);
        int dp_i_1 = 1;
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            int dp_i = 1;
            if (nums[i] > nums[i-1]){
                // dp[i] = dp[i-1] + 1;
                dp_i = dp_i_1 + 1;
            }
            dp_i_1 = dp_i;
            res = Math.max(res, dp_i);
        }
        return res;
    }
}
// @lc code=end

