/*
 * @lc app=leetcode.cn id=216 lang=java
 *
 * [216] 组合总和 III
 */

// @lc code=start

import java.util.LinkedList;
import java.util.List;

class Solution {
    LinkedList<Integer> path = new LinkedList<>();
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtrack(n, k, 1, 0);
        return res;
    }

    public void backtrack(int n, int k, int start,int sum){
        if (sum > n){
            return;
        }

        if (k == path.size()){
            if (sum == n){
                res.add(new LinkedList<>(path));
            }
            return;
        }


        for(int i = start; i <= 9 - (k - path.size()) + 1; i++){
            path.add(i);
            sum += i;
            backtrack(n, k, i + 1, sum);
            path.removeLast();
            sum -= i;
        }
    }
}
// @lc code=end

