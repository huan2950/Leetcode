/*
 * @lc app=leetcode.cn id=174 lang=java
 *
 * [174] 地下城游戏
 */

// @lc code=start
class Solution {
    //使用一维数组优化
    public int calculateMinimumHP(int[][] dungeon) {
        int row = dungeon.length;
        int col = dungeon[0].length;

        int[] dp = new int[col];

        //右下角dp值
        dp[col-1]= Math.max(1, 1-dungeon[row-1][col-1]);
        //最后一行dp值
        for (int j = col - 2; j >= 0; j--) {
            dp[j] = Math.max(1, dp[j+1] - dungeon[row-1][j]);
        }
        // //最后一列dp值
        // for (int i = row - 2; i >= 0; i--) {
        //     dp[i][col-1] = Math.max(1, dp[i+1][col-1] - dungeon[i][col-1]);
        // }

        for (int i = row-2;  i >= 0; i--){
            dp[col-1] = Math.max(1, dp[col-1] - dungeon[i][col-1]);
            for (int j = col-2; j >= 0; j--){
                dp[j] = Math.max(1, Math.min(dp[j], dp[j+1])-dungeon[i][j]);
            }
        }
        return dp[0];
    }
}
// @lc code=end
// 未优化的二维数组
// class Solution {
//     public int calculateMinimumHP(int[][] dungeon) {
//         int row = dungeon.length;
//         int col = dungeon[0].length;

//         int[][] dp = new int[row][col];

//         //右下角dp值
//         dp[row-1][col-1]= Math.max(1, 1-dungeon[row-1][col-1]);
//         //最后一行dp值
//         for (int j = col - 2; j >= 0; j--) {
//             dp[row-1][j] = Math.max(1, dp[row-1][j+1] - dungeon[row-1][j]);
//         }
//         //最后一列dp值
//         for (int i = row - 2; i >= 0; i--) {
//             dp[i][col-1] = Math.max(1, dp[i+1][col-1] - dungeon[i][col-1]);
//         }

//         for (int i = row-2;  i >= 0; i--){
//             for (int j = col-2; j >= 0; j--){
//                 dp[i][j] = Math.max(1, Math.min(dp[i+1][j], dp[i][j+1])-dungeon[i][j]);
//             }
//         }
//         return dp[0][0];
//     }
// }
