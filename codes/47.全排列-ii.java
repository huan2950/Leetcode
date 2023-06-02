/*
 * @lc app=leetcode.cn id=47 lang=java
 *
 * [47] 全排列 II
 */

// @lc code=start

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {

    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();
    boolean[] used;
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        used = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums);
        return res;
    }

    public void backtrack(int[] nums){
        int n = nums.length;
        if (track.size() == n){
            res.add(new LinkedList<>(track));
            return;
        }
        
        for (int i = 0; i < n; i++) {
            if(used[i] || (i > 0 && nums[i] == nums[i-1] && !used[i-1]))
                continue;
            track.add(nums[i]);
            used[i] = true;
            backtrack(nums);
            track.removeLast();
            used[i] = false;
        }
    }
}
// @lc code=end

