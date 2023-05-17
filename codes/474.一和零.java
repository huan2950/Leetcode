/*
 * @lc app=leetcode.cn id=474 lang=java
 *
 * [474] 一和零
 */

// @lc code=start
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for (int i = 0; i < strs.length; i++) {
            int[] zeroOnes = getZeroOnes(strs[i]);
            int zeros = zeroOnes[0],ones = zeroOnes[1];
            for (int j = m; j >= zeros; j--) {
                for (int k = n; k >= ones; k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j-zeros][k-ones]+1);
                }
            }
        }
        return dp[m][n];
    }

    public int[] getZeroOnes(String str){
        int[] zeroOnes = new int[2];
        char[] chars = str.toCharArray();
        for (char c : chars) {
            zeroOnes[c-'0']++;
        }
        return zeroOnes;
    }
 }
// @lc code=end

