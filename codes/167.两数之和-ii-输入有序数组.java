/*
 * @lc app=leetcode.cn id=167 lang=java
 *
 * [167] 两数之和 II - 输入有序数组
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int left = 0,right = numbers.length - 1;
        while(left < right){
            int sum = numbers[left] + numbers[right];
            if (sum == target){
                res[0] = left + 1;
                res[1] = right + 1;
                return res;
            }else if(sum < target){
                left++;
            }else if (sum > target){
                right--;
            }
        }
        res[0] = -1;
        res[1] = -1;
        return res;
    }
}
// @lc code=end

