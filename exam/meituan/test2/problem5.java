package exam.meituan.test2;

import java.util.Scanner;

public class problem5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++){
            int n = in.nextInt();
            int k = in.nextInt();
            int[] nums = new int[n];
            for (int j = 0; j < n; j++){
                nums[j] = in.nextInt();
            }
            boolean res = true;
            for (int l = 0; l < k; l++){
                int u = in.nextInt();
                int v = in.nextInt();
                nums[u - 1] += 1;
                nums[v - 1] -= 1;
            }
            for (int j = 1; j < n; j++){
                if (nums[j] < nums[j - 1]){
                    System.out.println("No");
                    res = false;
                    break;
                }
            }
            if (res) System.out.println("Yes");
        }
    }
}
