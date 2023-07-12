/*
 * @lc app=leetcode.cn id=496 lang=java
 *
 * [496] 下一个更大元素 I
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] greater = nextGreaterElement(nums2);

        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < nums2.length; i++){//将nums2中的元素和其对应的下一个更大元素放入map中
            map.put(nums2[i], greater[i]);
        }

        int[] res = new int[nums1.length];

        for (int i = 0; i < res.length; i++) {
            res[i] = map.get(nums1[i]);
        }

        return res;
    }

    public int[] nextGreaterElement(int[] nums) {
        int n = nums.length;
        // 存放答案的数组
        int[] res = new int[n];
        Stack<Integer> s = new Stack<>(); 
        // 倒着往栈里放
        for (int i = n - 1; i >= 0; i--) {
            // 判定个子高矮
            while (!s.isEmpty() && s.peek() <= nums[i]) {
                // 矮个起开，反正也被挡着了。。。
                s.pop();
            }
            // nums[i] 身后的更大元素
            res[i] = s.isEmpty() ? -1 : s.peek();
            s.push(nums[i]);
        }
        return res;
    }
}
// @lc code=end

