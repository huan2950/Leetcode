package utils;

import java.util.Arrays;

// @lc code=start
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        final int INF = 10000 * 101 + 1;
        int[][] dp = new int[k+2][n];
        //初始化dp数组
        for (int i = 0; i < k+2; i++) {
            Arrays.fill(dp[i], INF);
        }
        dp[0][src]=0;
        

        for (int i = 1; i <= k+1; i++) {
            for (int[] flight : flights) {
                int t = flight[0],j = flight[1],cost = flight[2];
                dp[i][j] = Math.min(dp[i][j],dp[i-1][t]+cost);//状态转移
            }
        }

        // int res = Integer.MAX_VALUE;
        return dp[k+1][dst];
        
    }
}


public class Test {
    public static void main(String[] args) {
        // Create a new Solution instance
        Solution solution = new Solution();
        // Create a test case
        // int[][] matrix = {{0,0}};
        int n = 3;
        int[][] flights = {{0,1,100},{1,2,100},{0,2,500}};
        int src = 0;
        int dst = 2;
        int k=1;
        // Get the answer
        int res = solution.findCheapestPrice(n, flights, src, dst, k);
        // Print the answer
        System.out.println(res);
    }
}

