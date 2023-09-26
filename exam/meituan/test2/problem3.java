package exam.meituan.test2;

import java.util.Scanner;

public class problem3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int n = s.length();
        int[] s1 = new int[n];
        int[] s2 = new int[n];
        s1[0] = 1;
        s2[0] = 0;
        for (int i = 1; i < n; i++){
            s1[i] = s1[i - 1] ^ 1;
            s2[i] = s2[i - 1] ^ 1;
        }
        int[] preSum1 = new int[n + 1];
        int[] preSum2 = new int[n + 1];
        for(int i = 1; i <= n; i++){
            int cur = s.charAt(i - 1) - '0';
            if (cur != s1[i - 1]){
                preSum1[i] = preSum1[i - 1] + 1;
                preSum2[i] = preSum2[i - 1];
            }else{
                preSum1[i] = preSum1[i - 1];
                preSum2[i] = preSum2[i - 1] + 1;
            }
            // preSum1[i] = preSum1[i - 1] + cur != s1[i - 1] ? 1 : 0;
            // preSum2[i] = preSum2[i - 1] + cur != s2[i - 1] ? 1 : 0;
        }
        int res = 0;
        for (int i = 0; i < n; i++){
            for (int j = i + 1; j < n; j++){
                res += Math.min(preSum1[j + 1] - preSum1[i], preSum2[j + 1] - preSum2[i]);
            }
        }
        System.out.println(res);
    }
}
