/*
 * @lc app=leetcode.cn id=2789 lang=java
 *
 * [2789] 合并后数组中的最大元素
 */

// @lc code=start
class Solution {
    public long maxArrayValue(int[] nums) {
        long sum = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            sum = nums[i] <= sum ? nums[i] + sum : nums[i];
        }
        return sum;
    }
}
// @lc code=end

