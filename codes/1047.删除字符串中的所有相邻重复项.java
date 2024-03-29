/*
 * @lc app=leetcode.cn id=1047 lang=java
 *
 * [1047] 删除字符串中的所有相邻重复项
 */

// @lc code=start

import java.util.Stack;

class Solution {
    /*
     * 思路：栈
     * 使用栈存储遍历的字符，当前字符和栈顶相同,则弹出栈顶，否则入栈
     */
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
            // 注意，这里要加在字符串的前面
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }
}
// @lc code=end

