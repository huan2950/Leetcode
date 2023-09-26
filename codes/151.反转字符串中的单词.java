/*
 * @lc app=leetcode.cn id=151 lang=java
 *
 * [151] 反转字符串中的单词
 */

// @lc code=start
class Solution {
    public String reverseWords(String s) {
        int left = 0, right = s.length() - 1;
        // remove the leading spaces
        while(left <= right && s.charAt(left) == ' ') left++;
        // remove the trailing spaces
        while(left <= right && s.charAt(right) == ' ') right--;
        // remove the multiple spaces between two words
        int start = right;
        StringBuffer sb = new StringBuffer();
        // while (left <= right){
        //     char c = s.charAt(left);
        //     if(c != ' '){
        //         sb.append(c);
        //     } else if (sb.charAt(sb.length() - 1) != ' '){
        //         sb.append(c);
        //     }
        //     left++;
        // }
        // reverse the whole string from the end to start of the string
        while (start >= left){
            char c = s.charAt(start); 
            if (c != ' '){
                start--;
            }else {
                int temp = start;
                while (start >= left && s.charAt(--start) == ' ');
                sb.append(s.substring(temp + 1, right + 1) + " ");
                right = start;
            }
        }
        return sb.append(s.substring(start + 1, right + 1)).toString();
    }
}
// @lc code=end

