/*
 * @lc app=leetcode.cn id=239 lang=java
 *
 * [239] 滑动窗口最大值
 */

// @lc code=start

import java.util.LinkedList;
/*
 * 窗口滑动时会有元素加入和退出，那么就会可能存在最大值的更新
 ? 如何在最大值退出当前窗口时获取到次最大值(参考leetcode 155.最小栈的相似做法)?
 ! 使用单调队列,当有新元素加入窗口时,保持队列中的元素单调减顺序,这样即使有最大值退出
 ! 窗口，也能保留次最大值
 */
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

/*
 * 单调队列:队列中加入元素时保留元素的递增/减顺序
 */
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
    
    /*
     * 如果不是队头的元素,则不用删除
     * 只删除队头的元素
     */
    public void pop(int n) {
        if (n == maxq.getFirst()) {
            maxq.pollFirst();
        }
    }
}
// @lc code=end

