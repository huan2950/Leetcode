/*
 * @lc app=leetcode.cn id=202 lang=java
 *
 * [202] 快乐数
 */

// @lc code=start

import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while(n != 1){
            if(set.contains(n)){
                return false;
            }
            set.add(n);
            n = split(n);
        }
        return true;
    }

    public int split(int n){
        int sum = 0;
        while(n > 0){
            int temp = n % 10;
            sum += temp * temp;
            n /= 10;
        }
        return sum;
    }
}
// @lc code=end

