package acm;

import java.util.Scanner;

public class Main {
    private static final int mod = 1000000007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] w = new int[2 * n + 1];
        for (int i = 1; i <= n; i++) {
            w[i] = sc.nextInt();
            w[i + n] = w[i];
        }
        int [][] dp = new int[2 * n + 1][2 * n + 1];
        for (int len = 3; len <= n + 1; len++) {
            for (int l = 1; l + len - 1 <= n << 1; l++) {
                int r = l + len - 1;
                for (int k = l + 1; k < r; k++) {
                    dp[l][r] = Math.max(dp[l][r],
                                       (w[l] * w[k] % mod * w[r] % mod + dp[l][k] + dp[k][r]) % mod);
                }
            }
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans, dp[i][i + n]);
        }
        System.out.println(ans);
    }
}
