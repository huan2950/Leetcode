import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=300 lang=java
 *
 * [300] 最长递增子序列
 */

// @lc code=start
class Solution {
    /*
     * dp[i]表示以nums[i]结尾的序列中最长递增子序列的长度
     */
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i], dp[j]+1);// 取dp[j]+1的最大值
                }
            }
            res = Math.max(dp[i], res);
        }
        return res;
    }
}
// @lc code=end

// class Solution {
//     public int lengthOfLIS(int[] nums) {
//         int[] dp = new int[nums.length];
//         Arrays.fill(dp, 1);
//         int res = 1;
//         for (int i = 1; i < nums.length; i++) {
//             for (int j = 0; j < i; j++) {
//                 if (nums[j] < nums[i]){
//                     dp[i] = Math.max(dp[i], dp[j]+1);
//                 }
//             }
//             res = Math.max(dp[i], res);
//         }
//         return res;
//     }
// }