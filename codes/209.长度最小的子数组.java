/*
 * @lc app=leetcode.cn id=209 lang=java
 *
 * [209] 长度最小的子数组
 */

// @lc code=start
class Solution {
    /*
     * 思路：滑动窗口
     * 当子序列和没有达到target时，窗口增大，right++
     * 当子序列和达到target后，窗口减小，left++
     */
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0, left = 0, right = 0, minLen = Integer.MAX_VALUE;
        while (right <= nums.length - 1){ // right is the right boundary
            // 窗口增大
            while (sum < target && right <= nums.length - 1){
                sum += nums[right];
                right++;
            }
            // 窗口减小
            while(sum >= target){
                minLen = Math.min(minLen, right - left);
                sum -= nums[left];
                left++;
            }
        }
        return minLen < Integer.MAX_VALUE ? minLen : 0;
    }
}
// @lc code=end

