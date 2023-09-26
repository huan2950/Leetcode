/*
 * @lc app=leetcode.cn id=459 lang=java
 *
 * [459] 重复的子字符串
 */

// @lc code=start
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        String t = s + s;
        return t.substring(1, t.length()-1).contains(s);
    }
}
// @lc code=end

