package exam.shenxinfu;

import java.util.Arrays;

public class problem4 {
    public int min_cut_string(String s){
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++){
            Arrays.fill(dp[i], true);
        }

        for (int i = n - 1; i >= 0; i--){
            for (int j =i + 1; j < n; j++){
                dp[i][j] = dp[i + 1][j - 1] && (s.charAt(i) == s.charAt(j));
            }
        }

        int[] res = new int[n];
        Arrays.fill(res, Integer.MAX_VALUE);
        for (int i  = 0; i < n; i++){
            if (dp[0][i]){
                res[i] = 0;
            }else {
                for (int j = 0; j < i; j++){
                    if (dp[j + 1][i]){
                        res[i] = Math.min(res[i], res[j] + 1);
                    }
                }
            }
        }
        return res[n - 1];
    }
}

