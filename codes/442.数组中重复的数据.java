/*
 * @lc app=leetcode.cn id=442 lang=java
 *
 * [442] 数组中重复的数据
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        // 数组中的[1...N]应该hash到nums[0...N-1]中
        // 类似题: 41.缺失的第一个正数
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        if (n <= 1) return res;
        for (int i = 0; i < nums.length; i++){
            while (nums[i] != nums[nums[i] - 1]){
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < n; i++){
            if (nums[i] != i + 1){
                res.add(nums[i]); 
            }
        }
        return res;
    }

    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp; 
    }
}
// @lc code=end

