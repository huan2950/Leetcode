package exam.jinshan;

import java.util.Scanner;

public class problem2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        if (m == 1 && n == 1){
            System.out.println(0);
            return;
        }
        int[][] dp = new int[n+1][m+1];
        int res = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m;j++){
                if (i == 1 && j == 1) continue;
                else if (i == 1 && j >= 2)dp[i][j] = b;
                else if (i >= 2 && j == 1) dp[i][j] = a;
                else {
                    dp[i][j] = Math.max(dp[i-2][j-1] + a, dp[i-1][j-2] + b);
                }
                res = Math.max(res, dp[i][j]);
            }
        }
        System.out.println(res);
    }

}
