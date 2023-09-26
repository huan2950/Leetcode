package exam.huawei;

import java.util.Arrays;
import java.util.Scanner;

public class problem1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] dp = new int[101];
        // base case 
        dp[2] = 1;
        for (int i = 3; i <= 100; i++){
            int part = i / 3;
            dp[i] = part + dp[part + i % 3];
        }
        while(in.hasNext()){
            int num = in.nextInt();
            if (num == 0){
                break;
            }
            System.out.println(dp[num]);
        }
    }
}
