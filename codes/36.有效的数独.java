/*
 * @lc app=leetcode.cn id=36 lang=java
 *
 * [36] 有效的数独
 */

// @lc code=start
class Solution {
    public boolean isValidSudoku(char[][] board) {
        // 分别记录行列以及方块中数字出现的次数
        int[][] row = new int[9][9];
        int[][] col = new int[9][9];
        int[][] block = new int[9][9];
        int n = board.length;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                char c = board[i][j];
                if (c == '.') continue;
                int num = c - '0' - 1;
                int blockIndex = i / 3 * 3 + j / 3;
                if (row[i][num] == 1 || col[j][num] == 1 || block[blockIndex][num] == 1){
                    return false;
                }else{// 分别记录行、列以及方块中的数字位置次数
                    row[i][num] = 1;
                    col[j][num] = 1;
                    block[blockIndex][num] = 1;
                }
            }
        }
        return true;
    }
}
// @lc code=end

