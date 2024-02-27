/*
 * @lc app=leetcode.cn id=33 lang=java
 *
 * [33] 搜索旋转排序数组
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        /*
         *  时间复杂度为log(n)的话，一般都是二分查找
         */
        int n = nums.length;
        if (n == 0) return -1;
        int left = 0, right = nums.length-1;
        if (target == nums[left]) return left;
        if (target == nums[right]) return right;
        // if (target > nums[left]){
        //     //在数组的左半边查找，要先确定右边界
        //     while (nums[left] > nums[right]){
        //         int mid = left + (right - left)/2;
        //         right = mid;
        //     }
        //     // 此时的右边界一定>=right
        // }else{
        //     //在数组的右半边查找，要先确定左边界
        // }
        while (left <= right){
            int mid = left + (right - left)/2;
            if (target == nums[mid]) return mid;
            if (nums[mid] >= nums[0]){
                // 左半边有序
                if (target >= nums[0] && target <= nums[mid]){
                    // 在左半边查找
                    right = mid - 1;
                }else{
                    // 在右半边查找
                    left = mid + 1;
                }
            }else{// 右半边有序
                if (target >= nums[mid] && target <= nums[nums.length-1]){
                    // 在右半边查找
                    left = mid + 1;
                }else{
                    // 在左半边查找
                    right = mid - 1;
                }

            }
        }
        return -1;
    }
}
// @lc code=end

