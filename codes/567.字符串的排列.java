/*
 * @lc app=leetcode.cn id=567 lang=java
 *
 * [567] 字符串的排列
 */
import java.util.Map;
import java.util.HashMap;

// @lc code=start
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> need = new HashMap<Character, Integer>();
        Map<Character, Integer> window = new HashMap<Character, Integer>();
        for (char c : s1.toCharArray())//need数组不会变
            need.put(c, need.getOrDefault(c,0) + 1);
        
        int left = 0,right = 0;
        int valid = 0;//valid表示window中满足字符数量的字符个数

        while (right < s2.length()){
            char c = s2.charAt(right);
            right++;//增大窗口
            if (need.containsKey(c)){
                window.put(c, window.getOrDefault(c, 0)+ 1);
                if (window.get(c).equals(need.get(c))){//满足字符数量
                    valid++;
                }
            }
            while (right - left >= s1.length()){
                if (valid == need.size()){
                    return true;
                }
                char d = s2.charAt(left);
                if (need.containsKey(d)){
                    if (window.get(d).equals(need.get(d))){
                        valid--;
                    }
                    window.put(d, window.get(d)-1);//更新window中的数据
                }
                left++;
            }
        }
        return false;
    }
}
// @lc code=end

