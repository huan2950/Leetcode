/*
 * @lc app=leetcode.cn id=96 lang=java
 *
 * [96] 不同的二叉搜索树
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

class Solution {

    Map<Integer, Integer> map = new HashMap<>();
    public int numTrees(int n) {
        return countTrees(1, n);
    }
    
    public int countTrees(int low, int high){
        if(low > high)return 1;
        int res = 0;
        if(map.containsKey(high - low + 1)){
            return map.get(high - low + 1);
        }
        for (int i = low; i <= high; i++) {
            int leftNums = countTrees(low, i-1);
            int rightNums = countTrees(i+1, high);
            res += (leftNums * rightNums);
        }
        map.put(high - low + 1, res);
        return res;
    }
}
// @lc code=end

