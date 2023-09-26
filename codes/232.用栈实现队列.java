/*
 * @lc app=leetcode.cn id=232 lang=java
 *
 * [232] 用栈实现队列
 */

// @lc code=start

import java.util.Stack;

class MyQueue {

    private Stack<Integer> stackIn;
    private Stack<Integer> stackOut;
    private int size;
    public MyQueue() {
        stackIn = new Stack<>();
        stackOut = new Stack<>();
        size = 0;
    }
    
    public void push(int x) {
        stackIn.push(x);
        size++;
    }
    
    public int pop() {
        if (stackOut.isEmpty()){
            // push all elements from stackIn to stackOut
            while (!stackIn.isEmpty()){
                stackOut.push(stackIn.pop());
            }
        }
        size--;
        return stackOut.pop();
    }
    
    public int peek() {
        if (stackOut.isEmpty()){
            // push all elements from stackIn to stackOut
            while (!stackIn.isEmpty()){
                stackOut.push(stackIn.pop());
            }
        }
        return stackOut.peek();
    }
    
    public boolean empty() {
        return size == 0;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
// @lc code=end

