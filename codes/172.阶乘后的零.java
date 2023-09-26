/*
 * @lc app=leetcode.cn id=172 lang=java
 *
 * [172] 阶乘后的零
 */

// @lc code=start
class Solution {
    public int trailingZeroes(int n) {
        int ans = 0;
        long divisor = 5;
        while (divisor <= n){
            ans += n/divisor;
            divisor *= 5;
        }
        return ans;
    }
}
// @lc code=end

