/*
 * @lc app=leetcode.cn id=844 lang=java
 *
 * [844] 比较含退格的字符串
 */

// @lc code=start
class Solution {
    public boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1, j = t.length() - 1;
        int skipS = 0, skipT = 0;
        while (i >= 0 || j >=0){
            // skip the # of String s
            while(i >= 0){
                if (s.charAt(i) == '#'){
                    skipS++;
                    i--;
                }else {
                    if (skipS > 0){
                        skipS--;
                        i--;
                    } else {
                        break;
                    }
                }
            }
            // skip the # of String t
            while (j >= 0){
                if (t.charAt(j) == '#'){
                    skipT++;
                    j--;
                } else {
                    if (skipT > 0){
                        skipT--;
                        j--;
                    } else {
                        break;
                    }
                }
            }
            // compare the char
            if (i >= 0 && j >= 0){
                if (s.charAt(i) != t.charAt(j)){
                    return false;
                }
            } else {// one string is empty, the other is not
                if (i >= 0 || j >= 0){
                    return false;
                }
            }
            i--;
            j--;
        }
        return true;
    }
}
// @lc code=end

