/*
 * @lc app=leetcode.cn id=1143 lang=java
 *
 * [1143] 最长公共子序列
 */

// @lc code=start
class Solution {
    /*
     * p[i][j]表示$text_1[0:i]$和$text_2[0:j]$的序列中最长公共子序列的长度
     */
    // public int longestCommonSubsequence(String text1, String text2) {
    //     int m = text1.length();
    //     int n = text2.length();
    //     int[][] dp = new int[m+1][n+1];
    //     for (int i = 1; i <= m; i++) {
    //         for (int j = 1; j <= n; j++) {
    //             if (text1.charAt(i-1) == text2.charAt(j-1)) {
    //                 dp[i][j] = dp[i-1][j-1] + 1;
    //             }else{
    //                 dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
    //             }
    //         }
    //     }
    //     return dp[m][n];
    // }


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

