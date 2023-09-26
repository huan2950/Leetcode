/*
 * @lc app=leetcode.cn id=1047 lang=java
 *
 * [1047] 删除字符串中的所有相邻重复项
 */

// @lc code=start

import java.util.Stack;

class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (stack.empty() || stack.peek() != c){
                stack.push(c);
            } else {
                stack.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.empty()){
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }
}
// @lc code=end

