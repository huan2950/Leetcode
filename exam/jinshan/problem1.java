package exam.jinshan;

import java.util.Scanner;

public class problem1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++){
            nums[i] = in.nextInt();
        }
        if (n == 1){
            System.out.println(1);
            return;
        }
        if (n == 2){
            if (nums[1] - nums[0] <= 8){
                System.out.println(2);
            }else{
                System.out.println(1);
            }
            return;
        }
        int res = 0;
        int left = 0, right = 1;
        int pre = nums[0]; 
        while (right < n){
            if (nums[right] - pre <= 8){
                pre = nums[right];
                right++;
            }else{
                res = Math.max(res, right - left);
                left = right;
                pre = nums[left];
                right++;
            }
        }
        System.out.println(Math.max(res, right - left));
    }
}
