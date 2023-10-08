/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
            // int n = height.length;
            // if (n == 0) return 0;
            // int[] leftMax = new int[n];
            // int[] rightMax = new int[n];
            // leftMax[0] = height[0];
            // rightMax[n-1] = height[n-1];
            // for (int i = 1; i < n; i++) {
            //     leftMax[i] = Math.max(leftMax[i-1], height[i]);
            // }
            // for (int i = n-2; i >= 0; i--) {
            //     rightMax[i] = Math.max(rightMax[i+1], height[i]);
            // }
            // int res = 0;
            // for (int i = 0; i < n; i++) {
            //     res += Math.min(leftMax[i], rightMax[i]) - height[i];
            // }
            // return res;
    
            //双指针
            int n = height.length;
            if (n == 0) return 0;
            int leftMax = height[0];
            int rightMax = height[n-1];
            int left = 0, right = n-1;
            int res = 0;
            while (left <= right){
                leftMax = Math.max(leftMax, height[left]);
                rightMax = Math.max(rightMax, height[right]);
                if (leftMax < rightMax){
                    res += leftMax - height[left];
                    left++;
                }else{
                    res += rightMax - height[right];
                    right--;
                }
            }
            return res;
    }
}
// @lc code=end

