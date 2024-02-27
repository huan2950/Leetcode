/*
 * @lc app=leetcode.cn id=1316 lang=java
 *
 * [1316] 不同的循环子字符串
 */

// @lc code=start

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int distinctEchoSubstrings(String text) {
        int n = text.length();
        int res = 0;
        long[] prefixSum = new long[n + 1];
        long[] power = new long[n + 1];
        power[0] = 1;
        int P = 31;
        for (int i = 0; i < n; i++){
            prefixSum[i+1] = prefixSum[i] * P + (text.charAt(i) - 'a');
            power[i+1] = power[i] * P;
        }
        Set<String> set = new HashSet<>();
        for (int len = 2; len <= n; len+=2){
            for (int j = 0; j + len - 1 < n; j++){
                int start1 = j, end1 = j + len / 2 - 1;
                int start2 = j + len / 2, end2 = j + len - 1;
                if (end1 == start1) {
                    if(text.charAt(start1) == text.charAt(start2)){
                        if (!set.contains(text.substring(start1, end2 + 1))){
                            res++;
                            set.add(text.substring(start1, end2 + 1));
                        }
                    }
                }else {
                    long hash1 = prefixSum[end1 + 1] - prefixSum[start1] * power[len / 2];
                    long hash2 = prefixSum[end2 + 1] - prefixSum[start2] * power[len / 2];
                    if (hash1 == hash2){
                        if (!set.contains(text.substring(start1, end2 + 1))){
                            res++;
                            set.add(text.substring(start1, end2 + 1));
                        }
                    }
                }
            }
        }
        return res;
    }
}
// @lc code=end

