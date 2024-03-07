/*
 * @lc app=leetcode.cn id=2917 lang=java
 *
 * [2917] 找出数组中的 K-or 值
 */
/*
 * 思路：题目本质上是计算数组中所有数字每个比特位为1的数量
 * 
 */
// @lc code=start
class Solution {
    public int findKOr(int[] nums, int k) {
        // 按照题目描述 nums[i] < 2^31
        int res = 0;
        for (int i = 0; i < 31; i++){
            int count = 0;
            for (int num : nums){
                if (((num >> i) & 1) != 0){
                    count++;
                }
            }
            if (count >= k){
                res |= 1 << i;
            }
        }
        return res;
    }
}
// @lc code=end

