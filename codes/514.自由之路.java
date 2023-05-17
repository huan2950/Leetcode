import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=514 lang=java
 *
 * [514] 自由之路
 */

// @lc code=start
class Solution {
    public int findRotateSteps(String ring, String key) {
        int m = key.length();
        int n = ring.length();
        
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; ++i) {
            Arrays.fill(dp[i], 0x3f3f3f);
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            //初始化dp[0][0...n-1]
            if (key.charAt(0) == ring.charAt(i)) {
                int delta = Math.abs(i);
                dp[0][i] = Math.min(delta, n - delta);
                res = Math.min(res, dp[0][i]);
            }
        }

        if (m > 1){
            res = Integer.MAX_VALUE;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(key.charAt(i) == ring.charAt(j)) {//当前指针的位置
                    //上一个指针的可能位置k
                    for (int k = 0; k < n; k++) {
                        if (key.charAt(i-1) == ring.charAt(k)) {
                            int delta = Math.abs(j-k);//计算要移动的距离
                            dp[i][j] = Math.min(dp[i][j], dp[i-1][k] + Math.min(delta,n-delta));//更新要移动的最短距离
                        }
                        
                    }

                    if (i == m-1){
                        res = Math.min(res, dp[i][j]);
                    }
                }
            }
        } 

        return res + m;

    }
}
// @lc code=end

