/*
 * @lc app=leetcode.cn id=242 lang=java
 *
 * [242] 有效的字母异位词
 */

// @lc code=start
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        int[] countS = new int[26];
        int[] countT = new int[26];
        for (int i = 0; i < s.length(); i++){
            countS[s.charAt(i) - 'a']++;
            countT[t.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++){
            if (countS[i] != countT[i])
                return false;
        }
        return true;
    }
}
// @lc code=end

