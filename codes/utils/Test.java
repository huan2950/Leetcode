package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        //二维DP数组
        int[][] dp = new int[n+1][amount+1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= amount; j++) {
                if(j >= coins[i-1]){
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][amount];

        //一维DP数组优化
        // dp[j] = dp[j] dp[j-coin[i-1]]
        // int[] dp = new int[amount+1];
        // dp[0] = 1;

        // for (int coin : coins) {
        //     for (int i = 0; i <= amount; i++) {
        //         if (i >= coin){
        //             dp[i] = dp[i] + dp[i - coin];
        //         }
        //     }
        // }
        // return dp[amount];
    }
}


public class Test {
    public static void main(String[] args) {
        // Create a new Solution instance
        Solution solution = new Solution();

        // Create a test case
        int[] nums = {1,2,5}; 
        // String s = "111";
        int target = 5;
        // Get the answer
        int res = solution.change(target, nums);
        // int res = solution.strStr(haystack, needle);
        // Print the answer
        System.out.println(res);
    }
}

