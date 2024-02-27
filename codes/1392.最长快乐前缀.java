/*
 * @lc app=leetcode.cn id=1392 lang=java
 *
 * [1392] 最长快乐前缀
 */

// @lc code=start
class Solution {
    public String longestPrefix(String s) {
        int n = s.length();
        if (n <= 1) return "";
        // long[] prefixSum = new long[n + 1];
        long[] power = new long[n + 1];
        int P = 31;
        // long MOD = 1000000007;
        power[0] = 1;
        // for (int i = 0; i < n; i++){
        //     prefixSum[i+1] = (prefixSum[i] * P % MOD + (s.charAt(i) - 'a'))%MOD;
        //     power[i+1] = power[i] * P;
        // }
        int res = -1;
        long mul = 1;
        long prefix =0, suffix = 0;
        for (int i = 0; i < n - 1; i++){
            // s[0...i]和s[n-i-1...n-1]的hash值
            prefix = prefix * P + (s.charAt(i) - 'a');
            suffix = suffix + (s.charAt(n - i - 1) - 'a') * mul;
            mul = mul * P;
            if (prefix == suffix) res = i;
        }
        return res != -1 ?s.substring(0, res+1) : "";
    }
}
// @lc code=end

