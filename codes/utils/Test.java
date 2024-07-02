package utils;

import java.util.*;


/**
 * 思路：从左往右找到第一个质数，从右往左找到第一个质数，返回两个质数的距离
 */
class Solution {
    public int maximumPrimeDifference(int[] nums) {
        int left = 0;
        int n = nums.length;
        int right = n - 1;
        // 从左往右搜索
        while (left < n){
            if (isPrime(nums[left])){
                break;
            }
            left++;
        }
        // 从右往左搜索
        while (right > -1) {
            if (isPrime(nums[right])){
                break;
            }
            right--;
        }
        return right - left > 0 ? right - left : -1;
    }

    /** 判断一个数是否为质数 */
    public boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}


public class Test {
    public static void main(String[] args) {
        // Create a new Solution instance
        Solution solution = new Solution();
        // Create a test case
        int[] nums = {4,8,2,8}; 
        // int[][] nums = {{0,0},{0,2},{1,1},{2,0},{2,2},{3,3},{3,1},{3,0}}; 
        // String string1 = "2147483646";
        // String s = "111";
        // int target = -123;
        // int dividend = 2147483647;
        // int[] nums = {7, 8, 9, 10};
        int n = 4;
        // Get the answer
        int res = solution.maximumPrimeDifference(nums);
        // int res = solution.strStr(haystack, needle);
        // Print the answer
        System.out.println(res);

    }
}

