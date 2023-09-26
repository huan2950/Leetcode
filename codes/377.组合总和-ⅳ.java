/*
 * @lc app=leetcode.cn id=377 lang=java
 *
 * [377] 组合总和 Ⅳ
 */

// @lc code=start
class Solution {
    public int combinationSum4(int[] nums, int target) {
    // complete knapsack problem
    // dp[j] = sum(dp[j-nums[i]])
    // final result :dp[target]
    // base case: dp[i] = 1
    int[] dp  = new int[target + 1];
    dp[0] = 1;
    // for (int num: nums){
    //     for (int i  = 0; i <= target; i++){
    //         if (i > num){
    //             dp[i] += dp[i - num];
    //         }
    //     }
    // }
    for (int i = 1; i <= target; i++){
        for (int num : nums) {
            if (i >= num) dp[i] += dp[i - num];
        }
    }
    return dp[target];
    }
}
// @lc code=end

