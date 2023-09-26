/*
 * @lc app=leetcode.cn id=77 lang=java
 *
 * [77] 组合
 */

// @lc code=start

import java.util.LinkedList;
import java.util.List;

class Solution {

    List<List<Integer>> res = new LinkedList<>(); // the set of results
    
    LinkedList<Integer> track = new LinkedList<>(); // single result

    public List<List<Integer>> combine(int n, int k) {
        backtrack(n, 0, k);
        return res;
    }

    public void backtrack(int n, int start,int k){
        if (k == track.size()){
            res.add(new LinkedList<>(track));
            return;
        }
        //每一个结果都保存
        // res.add(new LinkedList<>(track));
        //使用start避免重复子集
        for (int i = start; i < n; i++) {
            track.add(i+1);
            backtrack(n, i+1,k);
            track.removeLast();
        }
    }
}
// @lc code=end

