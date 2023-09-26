/*
 * @lc app=leetcode.cn id=372 lang=java
 *
 * [372] 超级次方
 */

// @lc code=start
class Solution {
    public int superPow(int a, int[] b) {
        return indexPow(a, b, b.length-1);
    }

    public int indexPow(int a, int[] b, int index){
        if (index < 0) return 1;

        int last = b[index];
        index--;

        int part1 = superMode(a, last, 1337);
        int part2 = superMode(indexPow(a, b, index), 10, 1337);
        return part1 * part2 % 1337;
    }

    /**
     * 求 a 的 k 次方然后对 base 取模的结果
     * @param a 底数
     * @param k 指数
     * @param base 取模
     * @return a^k % base
     */
    public int superMode(int a, int k, int base){
        int res = 1;
        while (k > 0){
            if((k & 1) == 1){// k 是奇数
                res = (res * a) % base; // 结果乘上底数
            }
            k /= 2; // 指数减半
            // a = (a * a) % base; // 底数平方
            int temp = a % base;
            a = temp * temp % base; // 底数平方
        }
        return res;
    }
}
// @lc code=end

