/*
 * @lc app=leetcode.cn id=2369 lang=java
 *
 * [2369] 检查数组是否存在有效划分
 */

// @lc code=start
/*
 * 思路：
 * 数组存在有效划分的条件：
 * 1. 前n-2个元素有效划分且最后2个元素相等
 * 2. 前n-3个元素有效划分且最后3个元素相等或者递增
 * 两个条件满足其一即可
 ! 分解子问题——动态规划
 * dp[i]表示前i个元素能形成有效划分,要求dp[n]
 * dp[0]=true
 * dp[i] =(dp[i-2] && checkTwo(nums[i-2],nums[i-1])) 
 * || (dp[i-3] && checkThree(nums[i-3],nums[i-2],nums[i-1]))   
 */
class Solution {
    public boolean validPartition(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++){
            if (i >= 2){
                dp[i] = dp[i - 2] && checkTwo(nums[i - 2], nums[i - 1]);
            }
            // ! i>=3后要判断两次
            if (i >= 3){
                dp[i] = dp[i] || (dp[i - 3] && checkThree(nums[i - 3], nums[i - 2], nums[i - 1]));
            }
        }
        return dp[n];
    }

    public boolean checkTwo(int num1, int num2){
        return num1 == num2;
    }
    
    public boolean checkThree(int num1, int num2, int num3){
        return (num1 == num2 && num2 == num3) || (num1 + 1 == num2 && num2 + 1 == num3);
    }
}
// @lc code=end

