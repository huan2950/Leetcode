package exam.jinshan;

import java.util.Scanner;

public class problem3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while (n-- > 0) {
            int[][][][] dp = new int[52][52][52][52];
            int ans = 0;
            String a = scanner.next();
            String b = scanner.next();
            int s = a.length();
            int t = b.length();

            for (int x = 0; x <= s; x++) {
                for (int y = 0; y <= t; y++) {
                    for (int i = 1, j = x; j <= s; i++, j++) {
                        for (int k = 1, l = y; l <= t; k++, l++) {
                            if (x + y <= 1) {
                                dp[i][j][k][l] = 1;
                            } else {
                                if (a.charAt(i - 1) == a.charAt(j - 1) && x > 1) {
                                    dp[i][j][k][l] |= dp[i + 1][j - 1][k][l];
                                }
                                if (b.charAt(k - 1) == b.charAt(l - 1) && y > 1) {
                                    dp[i][j][k][l] |= dp[i][j][k + 1][l - 1];
                                }
                                if (x > 0 && y > 0) {
                                    if (a.charAt(i - 1) == b.charAt(l - 1)) {
                                        dp[i][j][k][l] |= dp[i + 1][j][k][l - 1];
                                    }
                                    if (a.charAt(j - 1) == b.charAt(k - 1)) {
                                        dp[i][j][k][l] |= dp[i][j - 1][k + 1][l];
                                    }
                                }
                            }
                            if (dp[i][j][k][l] == 1) {
                                ans = Math.max(ans, x + y);
                            }
                        }
                    }
                }
            }
            System.out.println(ans);
        }
    }
}
