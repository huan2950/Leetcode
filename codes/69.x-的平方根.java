/*
 * @lc app=leetcode.cn id=69 lang=java
 *
 * [69] x 的平方根 
 */

// @lc code=start
class Solution {
    public int mySqrt(int x) {
        if (x == 0) return 0;
        if (x < 4) return 1;
        return search(x);
    }

    public int search(int num) {
        int left = 2, right = num / 2;
        while (left <= right) {
           int mid  = left + (right - left) / 2; 
           if (mid == num / mid) {
               return mid;
           } else if (mid < num / mid) {
               left = mid + 1;
           } else {
               right = mid - 1;
           } 
        }
        return right;
    }
}
// @lc code=end

