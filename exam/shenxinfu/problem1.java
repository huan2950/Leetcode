package exam.shenxinfu;

import java.util.Scanner;

public class problem1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] numStrs = in.nextLine().split(",");
        int n = numStrs.length;
        int[] nums = new int[n];
        long sum = 0;
        for (int i = 0; i < n; i++){
            nums[i] = Integer.parseInt(numStrs[i]);
            sum += nums[i];
        }

        int[] dp = new int[n];
        // for (int i = 0; i < n; i++){
        //     dp[i][0] = nums[i];
        // }

        for (int i = 0; i < n - 1; i++){
            dp[0] = nums[i];
            for (int j = 1; j <= i; j++){
                if (i + j < n){
                    dp[j] = dp[j - 1] + nums[i - j] + nums[i + j];
                    sum += dp[j];
                }
            }
        }
        System.out.println(sum);
    }
}
