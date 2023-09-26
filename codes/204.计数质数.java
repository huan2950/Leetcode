/*
 * @lc app=leetcode.cn id=204 lang=java
 *
 * [204] 计数质数
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);// 初始化
        for (int i = 2; i * i < n; i++) 
            if (isPrime[i]) 
                for (int j = i * i; j < n; j += i) 
                    isPrime[j] = false;
        
        int count = 0;
        for (int i = 2; i < n; i++)
            if (isPrime[i]) count++;
        
        return count;
    }

}
// @lc code=end

