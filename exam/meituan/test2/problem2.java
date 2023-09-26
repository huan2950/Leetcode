package exam.meituan.test2;

import java.util.Arrays;
import java.util.Scanner;

public class problem2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        long sum = 0;
        for (int i = 0; i < n; i++){
            nums[i] = in.nextInt();
            sum += nums[i];
        }
        long res = 0;
        long res1 = 0;
        long res2 = 0;
        if (sum % n == 0){
            long avg = sum / n;
            for (int i = 0; i < n; i++){
                res += Math.abs(nums[i] - avg);
            }
            System.out.println(res / 2);
            return;
        }else{
            long avg2 = sum / n + 1;
            // sort
            Arrays.sort(nums);
            int above1 = 0;
            int below1 = 0;
            for (int i = 0; i < n - 1; i++){
                if (nums[i] > avg2){
                    below1 += nums[i] -avg2;
                }else{
                    above1 += avg2 - nums[i];
                }
            }
            res1 = Math.max(above1, below1);
            int above2 = 0;
            int below2 = 0;
            for (int i = 1; i < n ; i++){
                if (nums[i] > avg2){
                    below2 += nums[i] -avg2;
                }else{
                    above2 += avg2 - nums[i];
                }
            }
            res2 = Math.max(above2, below2);
            System.out.println(Math.min(res1, res2));
        }
    }
}
