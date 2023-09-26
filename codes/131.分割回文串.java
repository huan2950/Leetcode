/*
 * @lc app=leetcode.cn id=131 lang=java
 *
 * [131] 分割回文串
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<String> path = new ArrayList<>();
    List<List<String>> res = new ArrayList<>();
    boolean [][] dp;
    public List<List<String>> partition(String s) {
        if (s.length() == 0) return res;
        isPalindrome(s);
        backtrack(s, 0);
        return res;
    }

    /**
     * 
     * @param s: the splited string
     * @param start: Initial partition point
     */
    public void backtrack(String s,int start){
        // the end condition is end of string
        if (start >= s.length()){
            res.add(new ArrayList<String>(path));
            return;
        }

        // make a choice
        for (int i = start; i < s.length(); i++){
            if (dp[start][i]){
                path.add(s.substring(start, i + 1));
            }else{
                continue;
            }
            backtrack(s, i + 1);
            path.remove(path.size() - 1);// removeLast
        }
    }

    // use dp to get the palindrome result of substring
    public void isPalindrome(String s){
        int n = s.length();
        dp = new boolean[n][n];

        for (int i = n - 1; i >= 0; i--){
            for (int j = i; j < n; j++){
                if (s.charAt(i) == s.charAt(j) && (j - i <= 1 || dp[i+1][j-1] )){
                    dp[i][j] = true;
                }
            }
        }
    }
}
// @lc code=end

