/*
 * @lc app=leetcode.cn id=11 lang=java
 *
 * [11] 盛最多水的容器
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        int i = 0,l = height.length-1;
        int res = 0;
        while(i < l){
            int area = Math.min(height[i], height[l])*(l-i);
            res = Math.max(res, area);
            if(height[i] <= height[l])
                i++;
            else l--;
        }
        return res;
    }
}
// @lc code=end

