/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        int[] res = new int[2];
        for(int i = 0;i < nums.length;i++){
            if(map.containsKey(target - nums[i])){
                res[0] = map.get(target - nums[i]);
                res[1] = i; 
                break;
            }
            map.put(nums[i],i);
        }
        return res;
    }
}
// @lc code=end

