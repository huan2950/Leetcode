/*
 * @lc app=leetcode.cn id=1997 lang=java
 *
 * [1997] 访问完所有房间的第一天
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

class Solution {
    // https://leetcode.cn/problems/first-day-where-you-have-been-in-all-the-rooms/solutions/2712369/javapython3cqian-zhui-he-dong-tai-gui-hu-04c8/?envType=daily-question&envId=2024-03-28
    /*
     * 理解题目意思：
     * nextVisit[]数组的意思是当访问房间i的次数为奇数时，回退到之前的房间
     * 只有当访问次数为偶数时才访问下一个房间
     * 因此从一个房间i访问到下一个房间i+1要经过三步：
     * 1. 首次访问房间i(用1天),此时房间[0,i-1]的访问次数一定是偶数次(因为只有前一个房间的访问次数为偶数次才能访问下一个房间)
     * 2. 回退到房间j(nextVisit[i]),再从房间j开始访问起,记住此时房间j的访问次数又成了奇数次(因为前面分析了[0,i-1]的访问次数为偶数次,加上这一次)，此时j也要进行回退...
     * 3. 从房间j开始访问下一个房间，直到再次访问到房间i(用1天)
     * 
     * 思路：利用重复的访问过程，进行动态规划
     * f[i]表示从房间i从奇数次访问开始到访问房间i+1的访问次数
     * 因此有f[i] = 1 + f[j] + f[j+1] + ... + f[i-1] + 1
     * 
     * 采用前缀和来进行优化:
     * s[i+1] = f[0] + ... + f[i]
     * 
     * 因此f[i] = s[i] - s[j] + 2
     * 由于s[i+1] = s[i] + f[i] (前缀和性质)
     * 因此s[i+1] = 2 * s[i] - s[j] + 2
     * 要求的结果为：
     * f[0] + f[1] + ... + f[n-2] + 1 = s[n-1] + 1
     */
    private static final int MOD = (int)1e9 + 7;
    public int firstDayBeenInAllRooms(int[] nextVisit) {
        int n = nextVisit.length;
        long[] s = new long[n];
        for (int i = 0; i < n - 1; i++) {
            int j = nextVisit[i];
            s[i + 1] = (s[i] * 2 - s[j] + 2 + MOD) % MOD; // + MOD 避免算出负数
        }
        return (int) s[n - 1];
    }
    // 模拟超时
    // // key房间号，value 访问次数
    // Map<Integer,Integer> map = new HashMap<>();
    // int n = nextVisit.length;
    // // 初始化
    // int visited = 0;// 访问了的房间数量
    // // 第一天访问
    // int i = 0;// 当前天数
    // int house = 0;
    // while (visited < n){
    //     // 判断当前房子是否访问过
    //     if (!map.containsKey(house)) {
    //         visited++;
    //         map.put(house, 0);
    //     }
    //     // 访问当前房子
    //     int times = map.get(house) + 1;
    //     map.put(house,times);
    //     // 选出下次要访问的房子
    //     if (times % 2 == 1){
    //         house = nextVisit[house];
    //     }else{
    //         house = (house + 1) % n;
    //     }
    //     i++;
    // }
    // return (i-1) % MOD;
}
// @lc code=end

