/*
 * @lc app=leetcode.cn id=7 lang=java
 *
 * [7] 整数反转
 */

// @lc code=start
class Solution {
    public int reverse(int x) {
        if (x == 0) return 0;
        int res = 0;
        while(x != 0){
            if (res > Integer.MAX_VALUE / 10 || res < Integer.MIN_VALUE / 10) return 0;
            int digit = x % 10;
            x /= 10;
            res = res * 10 + digit;
        }
        return res;
    }
}
// @lc code=end

