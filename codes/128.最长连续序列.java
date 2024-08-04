/*
 * @lc app=leetcode.cn id=128 lang=java
 *
 * [128] 最长连续序列
 */

// @lc code=start

import java.util.HashSet;
/**
 * 思路：使用hashset存储数据，遍历hashset，先判断x是否为连续序列的第一个数：
 *  - 如果是连续序列的第一个数，则判断x，x+1，x+2...是否在hashset中，记录最长的连续序列
 *  - 如果不是连续序列的第一个数，则跳过
 */
class Solution {
    public int longestConsecutive(int[] nums) {
        // HashSet去重
        HashSet<Integer> set = new HashSet<>();
        for (int num: nums){
            set.add(num);
        }
        int maxLength = 0;
        for (int num : set){
            // 判断是否为连续序列第一个数,如果x是连续序列第一个数，那么x-1应该不在set中
            if (!set.contains(num - 1)){
                int curLength = 1;
                int curNum = num;
                while (set.contains(curNum + 1)) {
                    // 更新连续序列的长度
                    curNum += 1;
                    curLength += 1;
                }
                // 更新当前最长连续序列
                maxLength = Math.max(maxLength, curLength);
            }
        }
        return maxLength;
    }
}
// @lc code=end

