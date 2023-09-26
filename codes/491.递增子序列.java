/*
 * @lc app=leetcode.cn id=491 lang=java
 *
 * [491] 递增子序列
 */

// @lc code=start

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {
    List<Integer> path = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        if (nums.length == 0) return res;
        backtrack(nums, 0);
        return res;
    }

    public void backtrack (int[] nums, int start){
        if (path.size() > 1){
            res.add(new ArrayList<>(path));
        }

        Set<Integer> hs = new HashSet<>();
        for (int i = start; i < nums.length; i++){
            if (!path.isEmpty() && nums[i] < path.get(path.size()-1) || hs.contains(nums[i])){
                continue;
            }
            // make choice
            path.add(nums[i]);
            hs.add(nums[i]);
            backtrack(nums, i + 1);
            // remove the choice
            path.remove(path.size() - 1);
        }
    }
}
// @lc code=end

