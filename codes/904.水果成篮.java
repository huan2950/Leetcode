/*
 * @lc app=leetcode.cn id=904 lang=java
 *
 * [904] 水果成篮
 */

// @lc code=start
class Solution {
    public int totalFruit(int[] fruits) {
        int type1 = -1, type2 = -1;// the type of fruits in the basket
        int num1 = 0, num2 = 0;// the number of two types of fruits in the basket 
        int max = 0; // the max number two type of fruits in the basket
        int left = 0, right = 0;// two points of the sliding window

        while (right <= fruits.length - 1){
            if (type1 == -1){
                type1 = fruits[right];
                num1++;
                right++;
                continue;
            }
            if (type2 == -1 && fruits[right] != type1){
                type2 = fruits[right];
                num2++;
                right++;
                continue;
            }
            while (fruits[right] == type1 || fruits[right] == type2){
                if (fruits[right] == type1){
                    num1++;
                } else {
                    num2++;
                }
                right++;
                if (right == fruits.length) break;
            }
            // when comes to the third type of fruits,update the max and change the sliding window
            max = Math.max(max, num1 + num2);
            // change the sliding window
            while (num1 > 0 && num2 > 0){
                if (fruits[left] == type1){
                    num1--;
                } else {
                    num2--;
                }
                left++;
            }
            type1 = num1 == 0 ? -1 : type1;
            type2 = num2 == 0 ? -1 : type2;

        }
        return max > num1 + num2 ? max : num1 + num2;
    }
}
// @lc code=end

