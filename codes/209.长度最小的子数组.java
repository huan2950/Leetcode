/*
 * @lc app=leetcode.cn id=209 lang=java
 *
 * [209] 长度最小的子数组
 */

// @lc code=start
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0, left = 0, right = 0, minLen = Integer.MAX_VALUE;
        while (right <= nums.length - 1){ // right is the right boundary
            while (sum < target && right <= nums.length - 1){
                sum += nums[right];
                right++;
            }
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

