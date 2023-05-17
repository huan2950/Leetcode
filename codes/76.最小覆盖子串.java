/*
 * @lc app=leetcode.cn id=76 lang=java
 *
 * [76] 最小覆盖子串
 */
import java.util.Map;
import java.util.HashMap;

// @lc code=start
class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<Character, Integer>();
        Map<Character, Integer> window = new HashMap<Character, Integer>();
        for (char c : t.toCharArray())
            need.put(c, need.getOrDefault(c,0) + 1);
        
        int left = 0,right = 0;
        int valid = 0;//valid表示window中满足字符数量的字符个数
        int len = Integer.MAX_VALUE;
        int start = 0;
        while (right < s.length()){
            char c = s.charAt(right);
            right++;//增大窗口
            if (need.containsKey(c)){
                window.put(c, window.getOrDefault(c, 0)+ 1);
                if (window.get(c).equals(need.get(c))){//满足字符数量
                    valid++;
                }
            }
            while (valid == need.size()){//找到可行解，开始优化
                if (right - left < len){
                    start = left;
                    len = right - left;
                }
                char d = s.charAt(left);
                if (need.containsKey(d)){
                    if (window.get(d).equals(need.get(d))){
                        valid--;
                    }
                    window.put(d, window.get(d)-1);//更新window中的数据
                }
                left++;
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start+len);
    }
}

// @lc code=end
