/*
 * @lc app=leetcode.cn id=29 lang=java
 *
 * [29] 两数相除
 */

// @lc code=start
class Solution {
    public int divide(int dividend, int divisor) {
        // 只有dividend为Integer.MIN_VALUE时，divisor为-1时会溢出，单独处理即可
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        // if (dividend == Integer.MIN_VALUE && divisor == 1) return Integer.MIN_VALUE;
        // if (dividend == Integer.MAX_VALUE && divisor == 1) return Integer.MAX_VALUE;
        // if (dividend == Integer.MAX_VALUE && divisor == -1) return -Integer.MAX_VALUE;
        boolean same = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0);
        // 全都转为负数，防止溢出
        if (dividend > 0) dividend = -dividend;
        if (divisor > 0) divisor = -divisor;
        if (dividend > divisor) return 0;
        //  初级思路: 从0开始，每次加上divisior，直到小于dividend，记录加法的次数
        int res = 0;
        // int temp = divisor;
        // while (temp >= dividend){
        //     res++;
        //     temp += divisor;
        // }
       // // 优化思路：加上divisior，若大于dividend，则将divisior翻倍，继续加，直到小于dividend，记录加法的次数
        //  这种想法不好实践，比如-10和-3，只能计算到-6，剩下的-4不好计算
        // 应该对被除数进行动态处理，而不是累加除数
        // while (dividend <= divisor){
        //     res++;
        //     dividend -= divisor;
        // }
        // 这时才方便优化，找到一个小于dividend的最大的divisor的倍数，然后继续循环
        while (dividend <= divisor){
            int quotient = 1;
            int temp = divisor;
            // 防止temp溢出
            // 最小的int是-2^31,这里的temp的下限应该是-2^31/2=-2^30，因为后面有两个temp相加也不能溢出
            while (temp >= 0xc0000000 && temp + temp >= dividend){
                temp += temp;// 对除数一直翻倍
                quotient += quotient;
                // if (quotient != 0)
                System.out.println(temp+"---"+quotient);
                if (quotient == 536870912){
                    System.out.println("quotient: "+ quotient);
                }
            }
            res += quotient;
            System.out.println("res: "+ res);
            dividend -= temp;
        }
        return same ? res : -res;
    }
}
// @lc code=end

