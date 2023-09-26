/*
 * @lc app=leetcode.cn id=541 lang=java
 *
 * [541] 反转字符串 II
 */

// @lc code=start
class Solution {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        for (int i = 0; i < n; i += 2 * k) {
            if (i + k <= n) {
                reverseString(chars, i, i + k - 1);
            } else {
                reverseString(chars, i, n - 1);
            }
        }
        return new String(chars);
    }

    // reverse the string[left,right]
    public void reverseString(char[] s,int left, int right) {
        // int left = 0,right = s.length - 1;
        while(left < right){
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}
// @lc code=end

