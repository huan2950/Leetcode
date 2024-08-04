/*
 * @lc app=leetcode.cn id=560 lang=java
 *
 * [560] 和为 K 的子数组
 */

import java.util.HashMap;
import java.util.Map;

/**
  * 思路：
  1. 错误思路：组合问题+元素可重复+不可复选，回溯法，本题要求子数组是数组中元素的连续序列，不能用回溯法
  2. 连续非空序列——前缀和
  对于当前位置j,要找的是i<j且nums[i:j]=k的个数
  对于当前位置presum[j],要找到就是presum[j]-k的数量，因为presum[0:i]+nums[i:j]=presum[j]
  使用hashmap
  */
// @lc code=start
class Solution {
    public int subarraySum(int[] nums, int k) {
        // key：前缀和，value：key 对应的前缀和的个数
        Map<Integer, Integer> preSumFreq = new HashMap<>();
        // 对于下标为 0 的元素，前缀和为 0，个数为 1
        preSumFreq.put(0, 1);

        int preSum = 0;
        int count = 0;
        for (int num : nums) {
            preSum += num;

            // 先获得前缀和为 preSum - k 的个数，加到计数变量里
            if (preSumFreq.containsKey(preSum - k)) {
                count += preSumFreq.get(preSum - k);
            }

            // 然后维护 preSumFreq 的定义
            preSumFreq.put(preSum, preSumFreq.getOrDefault(preSum, 0) + 1);
        }
        return count;
    }
}
// @lc code=end

