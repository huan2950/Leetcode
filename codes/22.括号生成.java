/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        // 这种要记录结果的一般考虑用dfs深度优先搜索或者回溯
        List<String> res = new ArrayList<>();
        if (n == 0) return res;
        dfs("", 0, 0, n, res);
        return res;
    }

    public void dfs(String str, int left, int right, int total, List<String> res){
        if (left == total && right == total){
            res.add(str);
            return;
        }

        // 左括号的使用次数不能小于右括号
        if (left < right) return;
        if (left < total) dfs(str+"(",left+1, right, total, res);
        if (right < total) dfs(str+")",left, right+1, total, res);
    }
}
// @lc code=end

