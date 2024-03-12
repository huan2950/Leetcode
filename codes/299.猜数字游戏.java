/*
 * @lc app=leetcode.cn id=299 lang=java
 *
 * [299] 猜数字游戏
 */

// @lc code=start


class Solution {
    public String getHint(String secret, String guess) {
        int n = secret.length();
        int[] secretFreq  = new int[10];
        int[] guessFreq = new int[10];
        int bulls = 0, cows = 0;
        for (int i = 0;i < n; i++){
            if (secret.charAt(i) == guess.charAt(i)) bulls++;
            else {
                secretFreq[secret.charAt(i) - '0']++;
                guessFreq[guess.charAt(i) - '0']++;
            }
        }
        for (int i = 0; i < 10; i++){
            cows += Math.min(secretFreq[i], guessFreq[i]);
        }
        return Integer.toString(bulls) + "A" + Integer.toString(cows) + "B";
    }
}
// @lc code=end

