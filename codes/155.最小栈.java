/*
 * @lc app=leetcode.cn id=155 lang=java
 *
 * [155] 最小栈
 */

// @lc code=start
/* 
 * 思路：使用一个值来存储最小值，每次入栈时都进行比较并判断是否要更新最小值
 * //? 带来的问题：如果最小值被弹出栈了如何知道次小值？
 * //! 因此考虑使用一个辅助栈来存储每次更新前的最小值，这样就能在一个最小值弹出来之后栈顶就得到了次小值
 */

import java.util.Stack;

class MinStack {
    
    private Stack<Integer> dataStack;
    private Stack<Integer> minStack;

    public MinStack() {
        dataStack = new Stack<>();
        minStack = new Stack<>(); 
    }
    
    public void push(int val) {
        dataStack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek())minStack.push(val);
    }
    
    public void pop() {
        int val = dataStack.pop();
        if (val == minStack.peek()) minStack.pop();
    }
    
    public int top() {
        return dataStack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
// @lc code=end

