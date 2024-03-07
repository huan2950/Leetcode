/*
 * @lc app=leetcode.cn id=2575 lang=java
 *
 * [2575] 找出字符串的可整除数组
 */
/*
 * 一个数ij
 * (i % x * 10 + j) % x = (i * 10 + j) % x
 */
// @lc code=start
class Solution {
    public int[] divisibilityArray(String word, int m) {
        int n = word.length();
        long remain = 0;
        int[] res = new int[n];
        for (int i = 0; i < n; i++){
            remain = (remain * 10 + word.charAt(i) - '0') % m;
            res[i] = (remain == 0) ? 1 : 0;
        }
        return res;
    }
}
// @lc code=end

