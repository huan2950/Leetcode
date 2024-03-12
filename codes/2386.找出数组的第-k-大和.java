/*
 * @lc app=leetcode.cn id=2386 lang=java
 *
 * [2386] 找出数组的第 K 大和
 */
/*
 * 1. 对于有正数和负数的数组，最大的子序列和就是所有正数的和sum
 * 2. 第二大的子序列和为最大子序列和——减去一个最小正数或者加上一个绝对值最小的负数
 ? 这里怎么处理最小正数和绝对值最小的负数？
 ! 将负数转化为正数(取绝对值),再进行排序,最后减去最小的正数即可
 * 4. 题目转换为求第k小的子序列和
 ? 如何理解?
 ! 子序列和:(这里初始化第0大为sum)
 ! 第 1 大 = 第 0 大 - 第 1 小子序列(0)
 ! 第 2 大 = 第 0 大 - 第 2 小子序列
 ! 第 3 大 = 第 0 大 - 第 3 小子序列
 ! 第 k 大 = 第 0 大 - 第 k 小子序列
 * 5. 第 k 小子序列构造: 先对数组取绝对值,再排序,元素从小到大加入子序列，每次构造子序列都有两种方式:替换当前序列或者加入新元素
 */
// @lc code=start

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public long kSum(int[] nums, int k) {
        int n = nums.length;
        // 求最大子序列和sum
        long sum = 0;
        for (int i = 0; i < n; i++){
            if (nums[i] >= 0) sum += nums[i];
            else { 
                // 取绝对值
                nums[i] = -nums[i];
            }
        }
        // 数组排序
        Arrays.sort(nums);
        //构造小根堆，每个小根堆元素为[子序列和,子序列中最后一个元素的索引],索引是为了得到下一个要替换或加入的数
        Queue<long[]> pq = new PriorityQueue<>((o1, o2) -> Long.compare(o1[0], o2[0]));
        // 初始化
        pq.offer(new long[]{0, -1});
        for (int i = 0; i < k - 1; i++){
            long[] polled = pq.poll();
            int curIndex = (int) polled[1];
            // 到达数组末尾，则不构造了
            if (curIndex == n - 1) continue;
            long curMin = polled[0];
            // 替换当前子序列的最后一个元素
            if (curIndex >= 0)
                pq.offer(new long[]{curMin - nums[curIndex] + nums[curIndex + 1], curIndex + 1});
            // 加入下一个元素
            pq.offer(new long[]{curMin + nums[curIndex + 1], curIndex + 1});
        }
        return sum - pq.peek()[0];

    }
}
// @lc code=end

