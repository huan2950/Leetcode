/*
 * @lc app=leetcode.cn id=2580 lang=java
 *
 * [2580] 统计将重叠区间合并成组的方案数
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    /*
     * 思路：区间合并
     * 先将数组按照第一列排序，再合并区间
     * 合并完所有的大区间之后，大区间数为m,分组方案为2^m
     */
    static final int MOD = 1000000007;

    public int countWays(int[][] ranges) {
        Arrays.sort(ranges, (a, b) -> a[0] - b[0]);
        int n = ranges.length;
        int res = 1;
        for (int i = 0; i < n; ){
            // 区间的右边界
            int right = ranges[i][1];
            int j = i + 1;
            while ( j < n && ranges[j][0] <= right){
                // 扩大右边界
                right = Math.max(right, ranges[j][1]);
                j++;
            }
            // 计算出一个大的区间
            res = res * 2 % MOD;
            i = j;
        }
        return res;
    }
}
// @lc code=end

