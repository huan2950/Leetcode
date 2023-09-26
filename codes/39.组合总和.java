/*
 * @lc app=leetcode.cn id=39 lang=java
 *
 * [39] 组合总和
 */

// @lc code=start

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {

    List<List<Integer>> res = new LinkedList<>();
    
    LinkedList<Integer> track = new LinkedList<>();

    int sum = 0;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates, target, 0);
        return res;
    }

    public void backtrack(int[] nums,int target,int start) {
        if (sum == target) {
            res.add(new LinkedList<>(track));
            return;
        }
        // base case，超过目标和，直接结束

        for (int i = start; i < nums.length; i++) {
            if (sum + nums[i] > target) {// cut the leaves
                break;
            }
            track.add(nums[i]);
            sum += nums[i];
            backtrack(nums, target, i);
            track.removeLast();
            sum -= nums[i];
        }
    }
}
// @lc code=end

