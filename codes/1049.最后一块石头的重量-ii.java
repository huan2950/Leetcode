/*
 * @lc app=leetcode.cn id=1049 lang=java
 *
 * [1049] 最后一块石头的重量 II
 */

// @lc code=start
// class Solution {
//     public int lastStoneWeightII(int[] stones) {
//         int n = stones.length;
//         int sum = 0;
//         for (int i : stones) {
//             sum += i; 
//         }
//         // dp[i][j] is the maximum weight of a backpack with a capacity of j for the first I stone
//         // max = dp[n][sum/2]
//         // res = sum - 2 * max;
//         int target = sum / 2;
//         int[][] dp = new int[n+1][target + 1];
//         // base case

//         for (int i = 1; i <= n; i++) {
//             for (int j = 1; j <= target; j++) {
//                 if (j >= stones[i-1]){
//                     dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - stones[i-1]] + stones[i-1]);
//                 }else {
//                     dp[i][j] = dp[i-1][j];
//                 }
//             }
//         }
//         return sum - 2 * dp[n][target];
//     }
// }

class Solution {
    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;
        int sum = 0;
        for (int i : stones) {
            sum += i; 
        }
        // dp[i][j] is the maximum weight of a backpack with a capacity of j for the first I stone
        // max = dp[n][sum/2]
        // res = sum - 2 * max;
        int target = sum / 2;
        // int[][] dp = new int[n+1][target + 1];
        int[] dp = new int[target + 1];
        // base case

        for (int i = 1; i <= n; i++) {
            for (int j = target; j >= stones[i-1]; j--) {
                // if (j >= stones[i-1]){
                //     dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - stones[i-1]] + stones[i-1]);
                // }else {
                //     dp[i][j] = dp[i-1][j];
                // }
                dp[j] = Math.max(dp[j], dp[j-stones[i-1]] + stones[i-1]);
            }
        }
        return sum - 2 * dp[target];
    }
}

// @lc code=end

