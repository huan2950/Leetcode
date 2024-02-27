/*
 * @lc app=leetcode.cn id=1044 lang=java
 *
 * [1044] 最长重复子串
 */

// @lc code=start

import java.util.HashSet;
import java.util.Set;

class Solution {
    public String longestDupSubstring(String s) {
        int l = 1,r = s.length() - 1;
        int resIndex = -1,resLen = 0;
        int n = s.length();
        int P = 31;
        // 次方数组
        //power = [P^0, P^1, P^2, ..., P^(n)]
        long[] power = new long[n + 1];
        power[0] = 1;
        // 前缀和数组
        long[] prefixSum = new long[n + 1];
        for (int i = 0; i < n; i++){
            power[i+1] = power[i] * P; 
            prefixSum[i+1] = prefixSum[i] * P + (s.charAt(i) - 'a');
        }
        while (l <= r){
            int mid = l + (r - l + 1) / 2;
            int index = search(s,mid,power,prefixSum);
            if (index == -1){
                r = mid - 1;
            }
            else{
                l = mid + 1;
                resLen = mid;
                resIndex = index;
            }
        }
        return resIndex != -1 ? s.substring(resIndex,resIndex+resLen): "";
    }

    // 利用字符串哈希进行查找
    public int search (String s, int len,long[] power,long[] prefixSum){
        int n = s.length();
        Set<Long> set = new HashSet<>();
        for (int i = 1; i + len - 1 <= n; i++) {
            int j = i + len - 1;
            // s[i...j]的hash值
            long cur = prefixSum[j] - prefixSum[i - 1] * power[j - i + 1];
            if (set.contains(cur)) return i-1;
            set.add(cur);
        }
        return -1;

        // Set<String> set = new HashSet<>();
        // for (int i = 0; i < s.length() - len + 1; i++){
        //     String tmp = s.substring(i,i+len);
        //     if (set.contains(tmp)){
        //         return i;
        //     }
        //     set.add(tmp);
        // }
        // return -1;
    }
}
// @lc code=end