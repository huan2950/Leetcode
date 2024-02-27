package utils;

import java.util.*;



class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++){
            // 最小的整数应该在[1,n+1]区间内
            while (nums[i] > 0 && nums[i] <= n && nums[i] != nums[nums[i] - 1]){
                swap(nums, i, nums[i] - 1);
            }
        }

        for (int i = 0; i < n; i++){
            if (nums[i] != i + 1){
                return i + 1;
            }
        }
        return n + 1;
    }
    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp; 
    }
}


public class Test {
    public static void main(String[] args) {
        // Create a new Solution instance
        Solution solution = new Solution();
        // Create a test case
        // int[][] nums = {{0,0},{0,2},{1,1},{2,0},{2,2},{3,3},{3,1}}; 
        // int[][] nums = {{0,0},{0,2},{1,1},{2,0},{2,2},{3,3},{3,1},{3,0}}; 
        // String string1 = "2147483646";
        // String s = "111";
        // int target = -123;
        // int dividend = 2147483647;
        int[] nums = {7, 8, 9, 10};
        int n = 4;
        // Get the answer
        int res = solution.firstMissingPositive(nums);
        // int res = solution.strStr(haystack, needle);
        // Print the answer
        System.out.println(res);

    }
}

