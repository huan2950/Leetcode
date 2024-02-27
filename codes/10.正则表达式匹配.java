/*
 * @lc app=leetcode.cn id=10 lang=java
 *
 * [10] 正则表达式匹配
 */

// @lc code=start
class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m+1][n+1];
        // base case
        dp[0][0] = true;// Empty strings can match
        for(int i = 2; i <= n; i+=2){
            dp[0][i] = dp[0][i-2] && p.charAt(i-1) == '*';
        }
        for (int i = 1; i <= m; i++){
            for (int j = 1; j <= n; j++){
                if (p.charAt(j-1) == '*'){
                    dp[i][j] = dp[i][j-2] || dp[i-1][j] && (s.charAt(i-1) == p.charAt(j-2) || p.charAt(j-2) == '.');
                }else{
                    dp[i][j] = dp[i-1][j-1] && (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.');
                }
            }
        }
        return dp[m][n];
    }
}
// @lc code=end

