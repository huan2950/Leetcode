/*
 * @lc app=leetcode.cn id=18 lang=java
 *
 * [18] 四数之和
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        
        for(int k = 0; k < nums.length - 2; k++){
            if(nums[k] > 0 && nums[k] > target) break;
            if(k > 0 && nums[k] == nums[k - 1]) continue;

            for (int l = k + 1; l < nums.length - 1; l++){
                if (l > k + 1 && nums[l] == nums[l-1]) continue; // skip the repeated numbers

                int i = l + 1, j = nums.length - 1;
                while(i < j){
                    int sum = nums[k] + nums[l] + nums[i] + nums[j];
                    if(sum < target){
                        while(i < j && nums[i] == nums[++i]);// skip the repeated numbers
                    } else if (sum > target) {
                        while(i < j && nums[j] == nums[--j]);
                    } else { // find a triplet
                        res.add(new ArrayList<Integer>(Arrays.asList(nums[k],nums[l], nums[i], nums[j])));
                        while(i < j && nums[i] == nums[++i]); // skip the same number of the answer
                        while(i < j && nums[j] == nums[--j]);
                    }
                }
            }
        }
        return res;

    }
}
// @lc code=end

