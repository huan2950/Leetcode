/*
 * @lc app=leetcode.cn id=189 lang=java
 *
 * [189] 轮转数组
 */
/**
 * 思路：
 * 1234567
 * 翻转整个数组：765 4321
 * 翻转前k个数：567 4321
 * 翻转后n-k个数：567 1234
 * 
 */
// @lc code=start
class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        // 轮转 n+k次等于轮转
        k = k % n;
        reverse(nums, 0, n-1);
        reverse(nums,0, k-1);
        reverse(nums,k ,n - 1);
    }

    public void reverse(int[] nums, int start, int end){
        int temp;
        while (start < end) {
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;

        }
    }
}
// @lc code=end

