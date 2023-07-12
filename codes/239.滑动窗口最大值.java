/*
 * @lc app=leetcode.cn id=239 lang=java
 *
 * [239] 滑动窗口最大值
 */

// @lc code=start

import java.util.LinkedList;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        MonotonicQueue window = new MonotonicQueue();
        int[] res = new int[nums.length - k + 1];
        // 先填满窗口的前 k - 1
        for (int i = 0; i < k - 1; i++) {
            window.push(nums[i]);
        }
        // 窗口开始向前滑动
        for (int i = k - 1; i < nums.length; i++) {
            // 窗口向前滑动一格，加入一个新的元素
            window.push(nums[i]);
            // 记录当前窗口的最大值
            res[i - k + 1] = window.max();
            // 移除最前面的元素
            window.pop(nums[i - k + 1]);
        }
        return res;
    }
}

class MonotonicQueue {
    LinkedList<Integer> maxq = new LinkedList<>();
    public void push(int n) {
        // 将小于 n 的元素全部删除
        while (!maxq.isEmpty() && maxq.getLast() < n) {

            maxq.pollLast();
        }
        // 然后将 n 加入尾部
        maxq.addLast(n);
    }
    
    public int max() {
        return maxq.getFirst();
    }
    
    public void pop(int n) {
        if (n == maxq.getFirst()) {
            maxq.pollFirst();
        }
    }
}
// @lc code=end

