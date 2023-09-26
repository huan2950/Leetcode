/*
 * @lc app=leetcode.cn id=349 lang=java
 *
 * [349] 两个数组的交集
 */

// @lc code=start

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length ==0)
            return new int[0];
        Set<Integer> set = new HashSet<>();
        Set<Integer> res = new HashSet<>();
        // traverse nums1
        for (int i = 0; i < nums1.length; i++){
            set.add(nums1[i]);
        }
        // traverse nums2
        for (int i = 0; i < nums2.length; i++){
            if (set.contains(nums2[i]))
                res.add(nums2[i]);
        }
        return res.stream().mapToInt(x -> x).toArray();
    }
}
// @lc code=end

