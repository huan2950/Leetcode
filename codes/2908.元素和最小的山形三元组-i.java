/*
 * @lc app=leetcode.cn id=2908 lang=java
 *
 * [2908] 元素和最小的山形三元组 I
 */

// @lc code=start
class Solution {
    /*
     * 思路：前后缀分解
     * 从左往右遍历数组，存储前i个数字中最小的元素
     * 从右往左遍历数组，记录后i个数字中最小的元素
     */
    static final int MAX = 1000;
    public int minimumSum(int[] nums) {
        int n = nums.length;
        int res = 1000;
        int[] left = new int[n];
        left[0] = MAX;
        // 左侧的最小值
        int leftMin = nums[0];
        for (int i = 1; i < n; i++){
            if (nums[i] > leftMin){
                left[i] = leftMin;
            }else{
                // 当前值比最小值小，则更新最小值，且当前值左侧的最小值不存在，记为MAX
                left[i] = MAX;
                leftMin = nums[i];
            }
        }
        // 右侧的最小值
        int rightMin = nums[n-1];
        // 从右往左遍历，一边更新最小值一边计算总和
        for (int i = n - 2; i > 0; i--){
            if (nums[i] > rightMin){
                res = Math.min(res, nums[i] + rightMin + left[i]);
            }else {
                rightMin = nums[i];// 更新当前最小值
            }
        }
        return res >= MAX ? -1 : res;
    }
}
// @lc code=end

