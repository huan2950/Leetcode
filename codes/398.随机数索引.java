/*
 * @lc app=leetcode.cn id=398 lang=java
 *
 * [398] 随机数索引
 */

// @lc code=start

import java.util.Random;

class Solution {

    private int[] nums;
    private Random random = new Random();

    public Solution(int[] nums) {
        this.nums = nums;
    }
    
    public int pick(int target) {
        int n = 0, ans = -1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == target){
                n++;
                if(random.nextInt(n) == 0)
                    ans = i;
            }
        }
        return ans;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
// @lc code=end

