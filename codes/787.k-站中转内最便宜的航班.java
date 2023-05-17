import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=787 lang=java
 *
 * [787] K 站中转内最便宜的航班
 */

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

        int res = INF;
        for (int i = 1; i <= k+1; i++) {
            res = Math.min(res,dp[i][dst]);
        }
        return res == INF ? -1 : res;
        
    }
}
// @lc code=end

