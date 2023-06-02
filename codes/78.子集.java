/*
 * @lc app=leetcode.cn id=78 lang=java
 *
 * [78] 子集
 */

// @lc code=start

import java.util.LinkedList;
import java.util.List;

class Solution {
    List<List<Integer>> res = new LinkedList<>();
    
    LinkedList<Integer> track = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0);
        return res;
    }

    public void backtrack(int[] nums, int start){
        //每一个结果都保存
        res.add(new LinkedList<>(track));
        //使用start避免重复子集
        for (int i = start; i < nums.length; i++) {
            track.add(nums[i]);
            backtrack(nums, i+1);
            track.removeLast();
        }
    }
}
// @lc code=end

