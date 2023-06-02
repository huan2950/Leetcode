/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 */

// @lc code=start
import java.util.List;
import java.util.LinkedList;

class Solution {
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(nums, track, used); 
        return res;
    }

    public void backtrack(int[] nums, LinkedList<Integer> track, boolean[] used) {
        //结束条件
        if (track.size() == nums.length){
            // res.add(track);
            // 为什么这里不能直接add(track)呢,因为这里传递的是参数的地址
            // 所以如果track里面的元素发生变化,那么也会影响到res
            // 事实上,遍历结束后回到了根节点,因此所有的track都变成了空
            res.add(new LinkedList<>(track));//这里要复制一份结果
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]){//没选择过
                // 做出选择
                track.add(nums[i]);
                used[i] = true;
                backtrack(nums, track, used);
                //回退
                track.removeLast();
                used[i] = false;
            }
        }
    }
}
// @lc code=end

