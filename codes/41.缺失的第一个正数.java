/*
 * @lc app=leetcode.cn id=41 lang=java
 *
 * [41] 缺失的第一个正数
 */
/*
* @Description: 
* @Author: timjoy
* @Date: 2023-10-24
* @LastEditTime: 2023-10-24
*/
/**
 * 首先思路为哈希表，用哈希表存储出现的数字，然后从1开始遍历，找到第一个不在哈希表中的数字
 * 但是这样空间复杂度为O(n)，不符合题目要求
 * 如何哈希表优化——使用数组作为哈希表
 * 将[1,N]这些数映射到数组[0,N-1]中，数字i存储到数组下标为i-1的位置，这样就可以用数组来代替哈希表
 * 之后再遍历数组，找到第一个数组元素和下标不对应的元素，就是缺少的最小正数
 */
// @lc code=start
class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++){
            // 最小的整数应该在[1,n+1]区间内
            while (nums[i] > 0 && nums[i] <= n && nums[i] != nums[nums[i] - 1]){
                swap(nums, i, nums[i] - 1);
            }
        }

        for (int i = 0; i < n; i++){
            if (nums[i] != i + 1){
                return i + 1;
            }
        }
        return n + 1;
    }
    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp; 
    }
}
// @lc code=end

