/*
 * @lc app=leetcode.cn id=215 lang=java
 *
 * [215] 数组中的第K个最大元素
 */

// @lc code=start
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int low = 0, high = nums.length - 1;
        //! 实际上求数组第k大的元素是求数组中第n-k+1小的元素
        //! 数组中第n-k+1小的元素的索引为n-k,因此这里的k为索引
        k = nums.length - k;
        while (low <= high) {
            int j = partition(nums, low, high);//j为划分后基准元素的位置,也即第j+1小的元素
            if (j == k) {
                return nums[j];
            } else if (j < k) {
                low = j + 1;
            } else {
                high = j - 1;
            }    
        }
        return -1;
    }

    public int partition(int[] nums, int low, int high){
        int p = nums[low];
        int i = low + 1,j = high;
        while(i <= j){
            while (i < high && nums[i] <= p) i++;
            while (j > low && nums[j] > p) j--;
            if (i >= j) break;
            swap(nums, i, j);
        }
        swap(nums, low, j);
        return j;//这里的j是划分元素p的位置
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i]; nums[i] = nums[j]; nums[j] = temp;
    }
}
// @lc code=end

