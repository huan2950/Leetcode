/*
 * @lc app=leetcode.cn id=718 lang=java
 *
 * [718] 最长重复子数组
 */

// @lc code=start
class Solution {
    /*
     * dp[i][j]表示A的前i个元素组成的子数组和B的前j个元素组成的子数组的最长重复子数组
     */
    public int findLength(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        // int[][] dp = new int[m + 1][n + 1];
        int[] dp = new int[n + 1];
        int res = 0;
        for (int i = 1; i <= m; i++){
            for (int j = n; j > 0; j--){
                if (nums1[i-1] == nums2[j-1]){
                    dp[j] = dp[j-1] + 1;
                } else {
                    dp[j] = 0;
                }
                res = Math.max(res, dp[j]);
            }
        }
        return res;
    }
}
// @lc code=end

