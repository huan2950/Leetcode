/*
 * @lc app=leetcode.cn id=35 lang=java
 *
 * [35] 搜索插入位置
 */

// @lc code=start
class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        // target is smaller than the first element 
        if (target < nums[0]) return 0;
        // target is larger than the last element
        if (target > nums[right]) return right + 1;
        while (left <= right) {
           int mid  = left + (right - left) / 2; 
           if (nums[mid] == target) {
               return mid;
           } else if (nums[mid] < target) {
               left = mid + 1;
           } else {
               right = mid - 1;
           } 
        }
        return right + 1;
    }
}
// @lc code=end

