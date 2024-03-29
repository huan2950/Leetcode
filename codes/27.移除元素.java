/*
 * @lc app=leetcode.cn id=27 lang=java
 *
 * [27] 移除元素
 */

// @lc code=start
class Solution {
/*
 * 思路：快慢指针
 * 快指针：寻找新数组的元素 ，新数组就是不含有目标元素的数组
 * 慢指针：更新元素
 */
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int slow = 0;
        for(int fast = 0; fast < n; fast++){
            if (nums[fast] != val){// 快指针寻找目标元素
                nums[slow] = nums[fast];// 找到后使用慢指针更新
                slow++;
            } 
        }
        return slow;
    }
}
// @lc code=end

