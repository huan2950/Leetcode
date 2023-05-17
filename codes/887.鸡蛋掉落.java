/*
 * @lc app=leetcode.cn id=887 lang=java
 *
 * [887] 鸡蛋掉落
 */

// @lc code=start
class Solution {
    public int superEggDrop(int k, int n) {
        int[][] dp = new int[k+1][n+1];//要求的是dp[k][n];

        //只有一层楼,只需试一次
        for (int i = 0; i <= k; i++){
            dp[i][1] = 1;
        }
        //只有一个鸡蛋，则最坏情况下有几层就要操作几次
        for(int i= 0; i <= n; i++){
            dp[1][i] = i;
        }

        for (int i = 2; i <= k; i++) {
            for (int j = 2; j <= n; j++) {
                // 采用穷举
                // int min = Integer.MAX_VALUE;
                // for (int x = 1; x <= j; x++) {
                //     min = Math.min(min, Math.max(dp[i-1][x-1],dp[i][j-x]));
                // }
                // dp[i][j] = min + 1;
                
                //二分搜索
                int left = 1;
                int right = j;
                while (left + 1< right) {
                    int mid = (left + right)/2;
                    int down = dp[i-1][mid-1];//对应单调递增的函数
                    int up = dp[i][j-mid];//对应单调递减的函数
                    if (down > up){//在mid左边
                        right = mid;
                    }else if(down < up){//在mid右边
                        left = mid;
                    }
                    else{
                        left = right = mid;
                    }
                }
                // 将范围缩小到 right - left <= 1
                int leftVal = Math.max(dp[i-1][left-1],dp[i][j-left]);
                int rightVal = Math.max(dp[i-1][right-1],dp[i][j-right]);
                dp[i][j] = Math.min(leftVal, rightVal) + 1;
            }
        }
        return dp[k][n];
    }
}
// @lc code=end

