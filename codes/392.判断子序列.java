/*
 * @lc app=leetcode.cn id=392 lang=java
 *
 * [392] 判断子序列
 */

// @lc code=start
class Solution {
    public boolean isSubsequence(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[] dp = new int[n+1];
        for (int i = 1; i <= m; i++){
            int pre = dp[0];
            for (int j = 1; j <= n; j++){
                int cur = dp[j];
                if (s.charAt(i-1) == t.charAt(j-1)){
                    dp[j] = pre + 1;
                }else{
                    dp[j] = dp[j-1];
                }
                pre = cur;
            }
        }
        return dp[n] == m;
    }
}
// @lc code=end

