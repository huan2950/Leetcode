import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=322 lang=java
 *
 * [322] 零钱兑换
 */

// @lc code=start
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];//这里数组表示从0到amouont的值
        Arrays.fill(dp, amount + 1);//初始化dp数组,用于判断不满足条件的情况
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin: coins){
                if (i - coin >= 0){//dp[负数]无意义
                    dp[i] = Math.min(dp[i], dp[i-coin]+1); //遍历coin
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount]; 
        
    }
}
// @lc code=end

