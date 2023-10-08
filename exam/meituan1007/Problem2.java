package exam.meituan1007;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Problem2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] minValue = new int[n];
        int[] nums = new int[n];
        for (int i = 0; i < n; i++){
            nums[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++){
            minValue[i] = in.nextInt();
        }
        Arrays.sort(nums);
        Arrays.sort(minValue);
        // int count = 0;
        int i = 0, j = 0;
        while (i < n){
            if(nums[i] < minValue[j]) i++;
            else {
                // count++;
                i++;
                j++;
            }
        }
        System.out.println(j);
        // List<Integer> nums = new ArrayList<>();
        // for (int i = 0; i < n; i++){
        //     nums.add(in.nextInt());
        // }
        // for (int i = 0; i < n; i++){
        //     minValue[i] = in.nextInt();
        // }
        // Collections.sort(nums);
        // int count = 0;
        // for (int i = 0; i < n; i++){
        //     if (!find(nums,minValue[i])){
        //         break;
        //     }
        //     count++;
        // }
        // System.out.println(count);
    }

    // public static boolean find(List<Integer> nums, int target){
    //     int left = 0;
    //     int right = nums.size() - 1;
    //     if (nums.get(right) < target) return false;
    //     while (left <= right){
    //         int mid = (left + right) / 2;
    //         if (nums.get(mid) == target){
    //             nums.remove(mid);
    //             return true;
    //         }else if (nums.get(mid) > target){
    //             right = mid - 1;
    //         }else {
    //             left = mid + 1;
    //         }
    //     }
    //     if (right < nums.size() - 1 && nums.get(right + 1) > target){
    //         nums.remove(right + 1);
    //         return true;
    //     }
    //     return false;
    // }
}
