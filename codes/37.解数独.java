/*
 * @lc app=leetcode.cn id=37 lang=java
 *
 * [37] 解数独
 */

// @lc code=start
class Solution {
    public void solveSudoku(char[][] board) {
        backtrack(board, 0, 0);
    }

    // Judge whether board[i][j] can fill in n
    public boolean isValid(char[][] board, int i, int j, char n){
        for (int k = 0; k < board.length; k++) {
            if (board[i][k] == n) return false;// Check the row
            if (board[k][j] == n) return false;// check the column
            if (board[(i/3)*3 + k/3][(j/3)*3 + k%3] == n) return false;// Check the 3*3 block
        }
        return true;
    }

    public boolean backtrack(char[][] board, int i, int j){
        // base case: the last row
        if (i == board.length) {
            return true;
        }

        // Go to the next row
        if (j == board[0].length) {
            return backtrack(board, i+1, 0);
        }

        // Numbers, no need to backtrack
        if (board[i][j] != '.'){
            return backtrack(board, i, j+1);// Go to the next column
        }

        // Empty, need to backtrack
        for (char n = '1'; n <= '9'; n++) {
            if (isValid(board, i, j, n)){
                board[i][j] = n;
                if(backtrack(board, i, j+1)){
                    return true;
                }
                board[i][j] = '.';
            }
        }
        return false;
    }
}
// @lc code=end

// line one
// line two
// line three
// you're going