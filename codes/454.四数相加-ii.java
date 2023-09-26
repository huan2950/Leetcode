/*
 * @lc app=leetcode.cn id=454 lang=java
 *
 * [454] 四数相加 II
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int count = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums1.length; i++){
            for (int j = 0; j < nums2.length; j++){
                int sum = nums1[i] + nums2[j];
                map.put(sum,map.getOrDefault(sum, 0) + 1);
            }
        }

        for(int i = 0; i < nums3.length; i++){
            for (int j = 0; j < nums4.length; j++){
                int sum = nums3[i] + nums4[j];
                if (map.containsKey(-sum)){
                    count += map.get(-sum);
                }
            }
        }
        return count;
    }
}
// @lc code=end

