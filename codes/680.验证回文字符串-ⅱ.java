/*
 * @lc app=leetcode.cn id=680 lang=java
 *
 * [680] 验证回文字符串 Ⅱ
 */

// @lc code=start
class Solution {
    public boolean validPalindrome(String s) {
        int i = 0,j = s.length()-1;
        while(i < j){
            if(s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            }
            else {
                return validPalindrome(s, i, j-1) || validPalindrome(s, i+1, j);
            }
        }
        return true;
    }

    public boolean validPalindrome(String s, int low, int high){
        while (low < high){
            if (s.charAt(low) != s.charAt(high))
                return false;
            else {
                low++;
                high--;
            }
        }
        return true;
    }
}

// @lc code=end

