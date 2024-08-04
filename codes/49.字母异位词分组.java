/*
 * @lc app=leetcode.cn id=49 lang=java
 *
 * [49] 字母异位词分组
 */

 /*
  * 思路一：将每个字符串排序后作为key，原字符串作为value，存入map中
  */
// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str: strs){
            // 将字符串转换为字符数组然后排序
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            // 重新排序后的字符串作为键，当前字符串作为值，存入hashmap
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
// @lc code=end

