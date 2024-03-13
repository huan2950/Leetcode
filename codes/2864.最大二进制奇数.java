/*
 * @lc app=leetcode.cn id=2864 lang=java
 *
 * [2864] 最大二进制奇数
 */

// @lc code=start
class Solution {
    public String maximumOddBinaryNumber(String s) {
        int n = s.length();
        int ones = 0;
        for (int i = 0; i < n; i++){
            if (s.charAt(i) == '1') {
                ones++;
            }
        }
        StringBuffer sb = new StringBuffer();
        if (ones == 1){
            // 只有一个1,放在最末尾
            for(int i = 0; i < n - 1; i++) sb.append("0");
        }else{
            // 多余的1全部放在最前面 1111...0001
            for (int i = 0; i < ones - 1; i++) sb.append("1");
            for (int i = 0; i < n - ones; i++) sb.append("0");
        }
        return sb.append("1").toString();
    }
}
// @lc code=end

