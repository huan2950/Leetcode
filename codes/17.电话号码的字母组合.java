/*
 * @lc app=leetcode.cn id=17 lang=java
 *
 * [17] 电话号码的字母组合
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<String> res = new ArrayList<>();
    StringBuffer sb = new StringBuffer();
    
    String[] numStrings = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return res;
        backtrack(digits, 0);
        return res;

    }

    /**
     * 
     * @param digits
     * @param num: the index of the current number
     */
    public void backtrack(String digits, int num){
        if (num == digits.length()){
            res.add(sb.toString());
            return;
        }

        String letters = numStrings[digits.charAt(num) - '0'];// get the letters of current number
        for (int i = 0; i < letters.length(); i++){
            // Make a choice
            sb.append(letters.charAt(i));
            //backtrack
            backtrack(digits, num + 1);
            // remove
            sb.deleteCharAt(num);
        }
    }
}
// @lc code=end

