/*
 * @lc app=leetcode.cn id=225 lang=java
 *
 * [225] 用队列实现栈
 */

// @lc code=start

import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    /*
     * 思路：
     * 入栈：元素先入队，然后将前面的元素先出队再入队，这样push进去的元素就成了队头，也就是栈顶
     */
    Queue<Integer> queue1;
    public MyStack() {
        queue1 = new LinkedList<>();
    }
    
    public void push(int x) {
        int size = queue1.size();
        queue1.offer(x);
        for (int i = 0; i < size; i++){
            queue1.offer(queue1.poll());
        }
    }
    
    public int pop() {
        return queue1.poll();
    }
    
    public int top() {
        return queue1.peek();
    }
    
    public boolean empty() {
        return queue1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
// @lc code=end

