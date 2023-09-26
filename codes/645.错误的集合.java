/*
 * @lc app=leetcode.cn id=645 lang=java
 *
 * [645] 错误的集合
 */

// @lc code=start
class Solution {
    int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int dup = -1;
        for (int i = 0; i < n; i++) {
            // 现在的元素是从 1 开始的
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0)
                dup = Math.abs(nums[i]);
            else
                nums[index] *= -1;
        }
    
        int missing = -1;
        for (int i = 0; i < n; i++)
            if (nums[i] > 0)
                // 将索引转换成元素
                missing = i + 1;
    
        return new int[]{dup, missing};
    }
}
// @lc code=end

