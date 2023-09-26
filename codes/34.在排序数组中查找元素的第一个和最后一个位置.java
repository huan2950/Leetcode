/*
 * @lc app=leetcode.cn id=34 lang=java
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 */

// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0 || target < nums[0] || target > nums[nums.length - 1] ) return new int[]{-1, -1};

        int leftBound = left_bound(nums, target);

        if (leftBound == -1) return new int[]{-1, -1};

        int right_bound = right_bound(nums, target);

        return new int[]{leftBound, right_bound};
    }

    public int left_bound(int[] nums, int target){
        int left = 0, right = nums.length - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (nums[mid] < target){
                left = mid + 1;
            } else {
                right = mid - 1;// shorten the right boundary
            }
        }
        if (left == nums.length) return -1;
        return nums[left] == target ? left : -1;
    }
    

    public int right_bound(int[] nums, int target){
        int left = 0, right = nums.length - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (nums[mid] > target){
                right = mid - 1;
            } else {
                left = mid + 1;// shorten the left boundary
            }
        }
        if (right < 0) return -1;
        return nums[right] == target ? right : -1;
    }
}
// @lc code=end

