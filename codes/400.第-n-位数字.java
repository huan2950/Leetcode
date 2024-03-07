/*
 * @lc app=leetcode.cn id=400 lang=java
 *
 * [400] 第 N 位数字
 */
/*
 * 1-9          9(base) * 1(len)
 * 10-99        90 * 2
 * 1000-9999    900 * 3
 * 先确定第n位所在的数在哪个范围内——即确定第n位数字所在的数的长度
 * 确定好数字的长度后再寻找数字
 */
// @lc code=start
class Solution {
    public int findNthDigit(int n) {
        int base = 9, len = 1;
        // 确定范围
        while (n > (long)base * len){
            n -= base * len; 
            base *= 10;
            len++;
        }
        // 数的长度为len，n为len位数中第一位到目标数字的位数
        // 第一位数
        int start = (int) Math.pow(10, len - 1);
        // 目标数
        int num = start + (n - 1) / len;
        int index = (n - 1) % len;
        return ( num / (int) Math.pow(10, len - index - 1) ) % 10;

    }
}
// @lc code=end

