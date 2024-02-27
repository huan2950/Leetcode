/*
 * @lc app=leetcode.cn id=214 lang=java
 *
 * [214] 最短回文串
 */

// @lc code=start
class Solution {
    public String shortestPalindrome(String s) {
        // 找最长回文前缀
        int n = s.length();
        if (n <= 1) return s;
        int max = 0;
        long MOD = 1000000007;
        int P = 31;
        // for (int i = 1; i < n; i++){
        //     int l = 0, r = i;
        //     boolean res = true;
        //     while (l <= r){
        //         if (s.charAt(l) == s.charAt(r)){
        //             l++;
        //             r--;
        //         }
        //         else{
        //             res = false;
        //             break;
        //         }
        //     }
        //     if (res) max = Math.max(max,i + 1);
        // }
        long prefixSum = 0, suffixSum = 0;
        long power = 1;
        for (int i = 0; i < n; i++){
            prefixSum = ( prefixSum * P + (s.charAt(i) - 'a') ) % MOD;
            suffixSum = (suffixSum + (s.charAt(i) - 'a') * power) % MOD;
            power = power * P % MOD;
            if (prefixSum == suffixSum) max = Math.max(max,i + 1);
        }

        return new StringBuffer( s.substring(max, n) ).reverse().append(s).toString();

    }
}
// @lc code=end

