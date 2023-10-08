package exam.meituan1007;

import java.util.Scanner;

public class Problem3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] str = in.nextLine().toCharArray();
        int n = str.length;
        // 区间dp
        int[][] dp = new int[n][n];
        for (int len = 3; len <= n; len++){
            //左端点
            for (int l = 0; l + len - 1 < n; l++){
                int r = l + len - 1;
                if (str[l] == 'm' )
            }
        }
    }
}
