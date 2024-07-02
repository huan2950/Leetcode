/*
* @lc app=leetcode.cn id=3115 lang=java
*
* [3115] 质数的最大距离
 */

// @lc code=start
class Solution {
    public int maximumPrimeDifference(int[] nums) {
        int left = 0;
        int n = nums.length;
        int right = n - 1;
        // 从左往右搜索
        // while ( left <= right && left < n - 1 && right > 0) {
        //     if (!isPrime(nums[left])) {
        //         left++;
        //     }
        //     if (!isPrime(nums[right])) {
        //         right--;
        //     }
        // }
        // return right - left > 0 ? right - left : -1;
        while (left < n){
            if (isPrime(nums[left])){
                break;
            }
            left++;
        }

        while (right > -1) {
            if (isPrime(nums[right])){
                break;
            }
            right--;
        }
        return right - left > 0 ? right - left : 0;
    }

    /** 判断一个数是否为质数 */
    public boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

