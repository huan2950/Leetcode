/*
 * @lc app=leetcode.cn id=647 lang=java
 *
 * [647] 回文子串
 */

// @lc code=start
class Solution {
    /*
     * dp[i][j]字符串s[i…j]范围内的子串是否为回文子串
     */
    public int countSubstrings(String s) {
        int n = s.length();
        int res = 0;
        
        boolean [][] dp = new boolean[n][n];
        for(int i = n - 1; i >= 0; i--){
            for(int j = i; j < n; j++){
                if (s.charAt(i) == s.charAt(j) && (j-i <= 1 || dp[i+1][j-1])){
                    res++;
                    dp[i][j] = true;
                }
            } 
        }
        return res;
    }
}
// @lc code=end

