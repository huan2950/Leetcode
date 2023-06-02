/*
 * @lc app=leetcode.cn id=90 lang=java
 *
 * [90] 子集 II
 */

// @lc code=start

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {

    List<List<Integer>> res = new LinkedList<>();
    
    LinkedList<Integer> track = new LinkedList<>();
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums, 0);
        return res;
    }

    public void backtrack(int[] nums, int start){
        //每一个结果都保存
        res.add(new LinkedList<>(track));
        //使用start避免重复子集
        for (int i = start; i < nums.length; i++) {
            if (i == start || nums[i] != nums[i-1]) {
                track.add(nums[i]);
                backtrack(nums, i+1);
                track.removeLast();
            }
        }
    }
}
// @lc code=end

