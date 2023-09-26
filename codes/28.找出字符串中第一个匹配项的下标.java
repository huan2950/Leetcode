/*
 * @lc app=leetcode.cn id=28 lang=java
 *
 * [28] 找出字符串中第一个匹配项的下标
 */

// @lc code=start
class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0){
            return 0;
        }
        int[] next = getNext(needle);
        int j = -1;
        for (int i = 0; i < haystack.length(); i++){
            while (j >= 0 && haystack.charAt(i) != needle.charAt(j+1)){
                j = next[j];
            }
            if (haystack.charAt(i) == needle.charAt(j+1)){
                j++;
            }
            if (j == needle.length()-1){
                return (i-needle.length()+1);
            }
        }
        return -1;
    }

    public int[] getNext(String s){
        int[] next = new int[s.length()];
        // init the next array
        int j = -1; // the position of j is the longest prefix and longest suffix
        next[0] = j;
        for (int i = 1; i < s.length(); i++){ // i is the position of the current character
            while (j >= 0 && s.charAt(i) != s.charAt(j+1)){
                j = next[j]; // backtrack to the previous longest prefix and longest suffix
            }
            if (s.charAt(i) == s.charAt(j+1)){
                j++;
            }
            next[i] = j;
        }
        return next;
    }
}
// @lc code=end


