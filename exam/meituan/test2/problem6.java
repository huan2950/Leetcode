package exam.meituan.test2;

import java.util.Scanner;

public class problem6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        int sum = 0;
        for(int i = 0; i < n; i++){
            a[i] = in.nextInt();
            sum += a[i];
        }
        long[][] dp = new long[n + 1][sum + 1];
        // dp[i][j]表示前i个数中选出若干个数，使得它们的和为j的方案数
        for (int i = 1; i <= sum - (n - 1); i++){
            if (i == a[0]) dp[1][i] = 0;
            else dp[1][i] = 1;
        }
        for (int i = 2; i <= n; i++){
            long sumPre = 0;
            for (int j = i; j <= sum; j++){
                sumPre += dp[i - 1][j - 1];
                if (j >= a[i - 1]){
                    dp[i][j] = sumPre - dp[i - 1][j - a[i - 1]];
                }else{
                    dp[i][j] = sumPre;
                }
                dp[i][j] %= 1000000007;
            }
        }
        System.out.println(dp[n][sum]);
    }
}
