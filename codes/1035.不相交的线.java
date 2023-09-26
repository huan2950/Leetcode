/*
 * @lc app=leetcode.cn id=1035 lang=java
 *
 * [1035] 不相交的线
 */

// @lc code=start
class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        // 本质上是求最长公共子序列的长度
        int m = nums1.length;
        int n = nums2.length;
        int[] dp = new int[n+1];

        for (int i = 1; i <= m; i++) {
            int pre = dp[0];
            for (int j = 1; j <= n; j++){
                int cur = dp[j];
                if (nums1[i-1] == nums2[j-1]){
                    dp[j] = pre + 1;
                }else{
                    dp[j] = Math.max(dp[j-1], dp[j]);
                }
                pre = cur;
            }
        }
        return dp[n];
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[] dp = new int[n+1];
        for (int i = 1; i <= m; i++) {
            int pre = dp[0];
            for (int j = 1; j <= n; j++) {
                int cur = dp[j];
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[j] = pre + 1;
                }else{
                    dp[j] = Math.max(dp[j-1], dp[j]);
                }
                pre = cur;
            }
        }
        return dp[n];
    }
}
// @lc code=end

