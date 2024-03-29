/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子数组和
 */

// @lc code=start

class Solution {
    //采用动态规划
    /*
     * p[i]表示以nums[i]结尾的最大子数组和
     */
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
// @lc code=end


// 不采用动态规划
// class Solution {
//     public int maxSubArray(int[] nums) {
//         int max = nums[0],sum = 0;
//         for (int num : nums) {
//             sum += num;
//             max = Math.max(max,sum);
//             sum = Math.max(sum,0);
//         }
//         return max;
        
//     }
// }
