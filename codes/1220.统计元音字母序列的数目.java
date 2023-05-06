import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1220 lang=java
 *
 * [1220] 统计元音字母序列的数目
 */

// @lc code=start
class Solution {
    public int countVowelPermutation(int n) {
        long MOD = 1000000007;
        long [] f = new long [5];//f表示当前长度i下的以不同字符结束的字符串个数
        long [] fnext = new long [5];//fnext表示长度i+1下以不同字符结束的字符串个数
        Arrays.fill(f,1);//长度为1的字符串个数为1

        /**
         * 最开始f表示i=1，fnext表示i=2
         * 最后fnext表示i=n,则f表示n-1,说明循环n-1次
         */
        for(int i = 1;i < n; i++){
            fnext[0] = (f[1] + f[2] + f[4])%MOD;
            fnext[1] = (f[0] + f[2])%MOD;
            fnext[2] = (f[1] + f[3])%MOD;
            fnext[3] = (f[2]);
            fnext[4] = (f[2] + f[3])%MOD;
            System.arraycopy(fnext, 0, f, 0, 5);//重新确定f
        }
        /**
         * 注意最后一次循环后,结果存放在f数组中
         */
        long sum = 0;
        for (int j = 0; j < 5; j++)
            sum = (sum+f[j])%MOD;
        return (int)sum;
    }

    public static void main(String[] args) {
        
    }
}
// @lc code=end

