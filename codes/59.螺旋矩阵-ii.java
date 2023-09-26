/*
 * @lc app=leetcode.cn id=59 lang=java
 *
 * [59] 螺旋矩阵 II
 */

// @lc code=start
class Solution {
    public int[][] generateMatrix(int n) {
        int l = 0, r = n - 1, t = 0, b = n - 1;
        int[][] res = new int[n][n];
        int num = 1, tar = n * n;
        while (num <= tar){
            // left top to top right
            for (int i = l; i <= r; i++) res[t][i] = num++;
            t++;
            // right top to right bottom
            for (int i = t; i <= b; i++) res[i][r] = num++;
            r--;
            // right bottom to left bottom
            for (int i = r; i >= l; i--) res[b][i] = num++;
            b--;
            for (int i = b; i >= t; i--) res[i][l] = num++;
            l++;
        }
        return res;
    }
}
// @lc code=end

