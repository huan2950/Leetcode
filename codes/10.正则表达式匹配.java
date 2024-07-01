/*
 * @lc app=leetcode.cn id=10 lang=java
 *
 * [10] 正则表达式匹配
 */

// @lc code=start
class Solution {
    /*
     * dp[i][j] 代表 s[:i](s前i个字符)与 p[:j] (p前j个字符) 是否可以匹配
     * 考虑dp[i][j]
     * p[j-1] = '*':
     * (1) *号匹配0个前面的字符p[j-2] 那就不用考虑p[j-2]了 只用考虑dp[i][j-2]
     * (2) *号匹配1次前面的字符p[j-2] 此时就考虑dp[i-1][j-2] && s[i-1] == p[j-2]
     * (3) *号前面的是'.',因为'.'可以匹配任意字符，那么还是只用考虑dp[i-1][j-2]就够了，不用比较元素是否相等了
     * 
     * p[j-1] != '*':
     * (1) 元素比较,即同时考虑dp[i-1][j-1]和s[i-1] ?= [j-1] 
     * (2) p[j-1] == '.',这时不用进行比较s[i-1]和p[j-1]
     * 
     * 初始化：
     * dp[0][0] = true 空字符串能够匹配
     * 要想模式串匹配空字符串，那么p的偶数为是'*'才行,也就是让奇数位匹配0次
     * 因此dp[0][j] = dp[0][j-2] && p[j-2] == *
     */
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

