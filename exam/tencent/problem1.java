package exam.tencent;

import java.util.HashMap;
import java.util.Map;

public class problem1 {
    
}

class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 返回满足题意的最小操作数
     * @param str string字符串 给定字符串
     * @return int整型
     */
    public int minOperations (String str) {
        // write code here
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int res = 0;
        int count = 0;
        for(char c: map.keySet()){
            int num = map.get(c);
            if (num % 2 == 0){
                res += num / 2;
                count += num / 2; 
            }else{
                res += num / 2;
                count += num / 2 + 1;
            }
        }
        if (count > 26){
            res += count - 26;
        }
        return res;
    }
}