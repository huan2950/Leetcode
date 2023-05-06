/*
 * @lc app=leetcode.cn id=125 lang=java
 *
 * [125] 验证回文串
 */
import java.lang.Character;
// @lc code=start
class Solution {
    public boolean isPalindrome(String s) {
        int p = 0;
        int q = s.length()-1;
        while(p < q){
            if (!Character.isLetterOrDigit(s.charAt(p)))//判断p处是否是数字或字母
                p++;
            else if (!Character.isLetterOrDigit(s.charAt(q)))//判断q处是否是数字或字母
                q--;
            else if (Character.toLowerCase(s.charAt(p)) != Character.toLowerCase(s.charAt((q))))//判断p、q处字符是否相等
                return false;
            else {
                p++;
                q--;
            }
        }
        return true;
    }
}
// @lc code=end

