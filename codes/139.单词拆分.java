/*
 * @lc app=leetcode.cn id=139 lang=java
 *
 * [139] 单词拆分
 */

// @lc code=start

import java.util.List;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for (int i = 1; i <= n; i++) {
           for (String word: wordDict){
                int l = word.length();
                if (i >= l && word.equals(s.substring(i-l, i)) && !dp[i]){
                    dp[i] |= dp[i-l];
                }
           }
        }
        return dp[n];
    }
}
// @lc code=end

