/*
 * @lc app=leetcode.cn id=303 lang=java
 *
 * [303] 区域和检索 - 数组不可变
 */

// @lc code=start
class NumArray {

    int[] preSums;
    
    public NumArray(int[] nums) {
        preSums = new int[nums.length+1];
        for (int i = 1; i < preSums.length; i++) {
            preSums[i] = preSums[i-1] + nums[i-1];
        }
    }
    
    public int sumRange(int left, int right) {
        return preSums[right+1] - preSums[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
// @lc code=end

