/*
 * @lc app=leetcode.cn id=153 lang=java
 *
 * [153] 寻找旋转排序数组中的最小值
 */
/*
 * 思路：看到O(log(n))的时间复杂度优先想到二分法
 * 先剔除升序排列的情况(nums[n-1] >= nums[0])，只考虑旋转后的数组
 * 对于数组第一个元素x,最小值右侧的都严格小于x,最小值左侧的都大于等于x
 *      
        *
    *(x)
                    *
                *
            *
   (0) (1) (2) (3) (4)
 * x就相当于普通二分查找中的target
 * num[mid] < x 说明mid在最小值的右侧，此时应该收紧右区间：right = mid
 ? 为什么这里要用mid?
 ! right = mid其实是和left < right绑定的：
 ! left < right的循环终止条件为left == right,此时要定位在最小值上,nums[left]为最小值
 ! lft <= right的循环终止条件为left + 1 == right,此时定位的是最大值上,nums[right]为最大值, nums[left]为最小值
 ! mid < x 有两种：
 ! 1. mid为如图的(3)：可以放心right = mid
 ! 2. mid为如图的(2)：此时mid - 1为最大值,循环终止时,left = right = 1,定位在最大值上,所以要用right = mid
 * num[mid] >= x 说明mid一定在最小值的左侧,此时应该收紧左区间,left = mid + 1
 ? 为什么这里可以用mid + 1?
 ! 因为此时mid一定在最小值左侧,即使mid + 1也最多就是回到最小值以及右侧,不会漏掉最小值,所以这里可以放心mid + 1
 */
// @lc code=start
class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1;
        if (n == 1 || nums[right] >= nums[left]){
            return nums[0];
        }
        while (left < right){
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[0]){
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        return nums[left];
    }
}
// @lc code=end

