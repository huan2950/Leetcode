package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int getSubarrayNum (ArrayList<Integer> a, int x) {
        // write code here
        int n = a.size();
        int l = 0, r = 0;
        int count2 = 0,count5 = 0;
        int res = 0;
        while (r < n){
            while (Math.min(count2, count5) < x && r < n){
                count2 += compute(a.get(r), 2);
                count5 += compute(a.get(r), 5);
                r++;
            }

            
            while (Math.min(count2, count5) >= x && l < r){
                res += n - r + 1;
                count2 -= compute(a.get(l), 2);
                count5 -= compute(a.get(l), 5);
                l++;
            }
        }
        return res % 1000000007;
    }

    public int compute(int num, int x){
        int res = 0;
        while (num % x == 0){
            res++;
            num /= x;
        }
        return res;
    }
}


public class Test {
    public static void main(String[] args) {
        // Create a new Solution instance
        Solution solution = new Solution();

        // Create a test case
        // int[] nums = {5,2,3,50,4}; 
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(5);
        a.add(2);
        a.add(3);
        a.add(50);
        a.add(4);
        // String s = "111";
        // Get the answer
        int res = solution.getSubarrayNum(a, 2);
        // int res = solution.strStr(haystack, needle);
        // Print the answer
        System.out.println(res);
    }
}

