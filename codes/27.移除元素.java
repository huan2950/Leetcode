/*
 * @lc app=leetcode.cn id=27 lang=java
 *
 * [27] 移除元素
 */

// @lc code=start
class Solution {
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int slow = 0;
        for(int fast = 0; fast < n; fast++){
            if (nums[fast] != val){
                nums[slow] = nums[fast];
                slow++;
            } 
        }
        return slow;
    }
}
// @lc code=end

