/*
 * @lc app=leetcode.cn id=347 lang=java
 *
 * [347] 前 K 个高频元素
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        // Use a hashmap to store the frequency of each number
        Map<Integer, Integer> map = new HashMap<>();
        // record the frequency of each number
        for (int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1] - b[1]));// min heap
        for (var entry : map.entrySet()){
            int[] element = {entry.getKey(), entry.getValue()};
            pq.offer(element);
            if (pq.size() > k){
                pq.poll();
            }
        }
        // k loop
        for (int i = 0; i < k; i++){
            res[i] = pq.poll()[0];
        }
        return res;
    }
}
// @lc code=end

