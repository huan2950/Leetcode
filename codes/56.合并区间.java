/*
 * @lc app=leetcode.cn id=56 lang=java
 *
 * [56] 合并区间
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 思路：
 * 1. 按照每个区间数组的第一个数对二维数组排序
 * 2. 遍历数组，遍历过程中合并
 * 时间复杂度：O(nlogn)
 * 空间复杂度：O(logn)
 */
// @lc code=start
class Solution {
    public int[][] merge(int[][] intervals) {
        // 按区间的start排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<int[]> res = new ArrayList<>();
        // 结果数组中最后一个合并区间的右边界，用来判断当前区间是否要合并进去
        // 如果resLast < start,则不会重合,可直接将当前区间加入结果数组中
        // 否则出现重合，要更新最后一个合并区间的右边界
        int resLast = intervals[0][1];
        for (int i = 0; i < intervals.length; i++){
            int start = intervals[i][0];
            int end = intervals[i][1];
            if (res.size() == 0 || resLast < start){
                res.add(intervals[i]);
                resLast = end;
            }else{
                resLast = Math.max(end, resLast);
                res.get(res.size()-1)[1] = resLast;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
// @lc code=end

