/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int maxLen = 0;
        int start = 0;
        for (int i = 0; i < n; i++){
            dp[i][i] = true;
            maxLen = 1;
        }
        for (int i = n-1; i >=0; i--){
            for (int j = i + 1; j < n; j++){
                if (j-i==1){
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                }
                else if (s.charAt(i) == s.charAt(j) && dp[i+1][j-1]){
                    dp[i][j] = true;
                }
                if (dp[i][j] && j - i + 1 > maxLen){
                        maxLen = j - i + 1;
                        start = i;
                    }
            }
        }
        return s.substring(start, start+maxLen);
    }
}
// @lc code=end

