/*
 * @lc app=leetcode.cn id=150 lang=java
 *
 * [150] 逆波兰表达式求值
 */

// @lc code=start

import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens){
            if (token.equals("+")){
                stack.push(stack.pop() + stack.pop());
            } else if (token.equals("-")){
                stack.push(-stack.pop() + stack.pop());
            } else if (token.equals("*")){
                stack.push(stack.pop() * stack.pop());
            } else if (token.equals("/")){
                int num1 = stack.pop();
                int num2 = stack.pop();
                stack.push(num2 / num1);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}
// @lc code=end

