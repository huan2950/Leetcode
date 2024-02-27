/*
 * @lc app=leetcode.cn id=8 lang=java
 *
 * [8] 字符串转换整数 (atoi)
 */

// @lc code=start
class Solution {
    public int myAtoi(String s) {
        int n = s.length();
        if (n == 0) return 0;
        int i = 0;
        int times = 1;
        int num = 0;
        while (i < n && !isDigit(s.charAt(i))){
            if (s.charAt(i) == ' ')i++;
            else if (s.charAt(i) == '-'){
                times = -1;
                i++;
                break;
            }
            else if (s.charAt(i) == '+'){
                i++;
                break;
            }else{
                break;
            }
        }
        while(i < n){
            if (isDigit(s.charAt(i))){
                int digit = s.charAt(i) - '0';
                if (num > Integer.MAX_VALUE / 10 || (num == Integer.MAX_VALUE / 10 && digit > 7)){
                   return times == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                else{
                    num = num * 10 + digit;
                    i++;
                }
            }
            else break;
        }
        return times * num;
    }

    public boolean isDigit(char c){
        return c >= '0' && c <= '9';
    }
}
// @lc code=end

