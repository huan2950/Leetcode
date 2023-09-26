package exam.meituan.test3;

import java.util.Arrays;
import java.util.Scanner;

public class problem6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for (int i = 0; i < q; i++){
            int n = in.nextInt();
            int m = in.nextInt();
            int[] nums1 = new int[n];
            int[] nums2 = new int[n];
            for (int j = 0; j < n; j++){
                nums1[j] = in.nextInt();
            }
            for (int j = 0; j < n; j++){
                nums2[j] = in.nextInt();
            }
            Arrays.sort(nums1);
            Arrays.sort(nums2);
            boolean flag = true;
            for (int k = 0; k < n; k++){
                int sum = nums1[k] + nums2[n - k - 1];
                if (sum < 1 || sum > m){
                    System.out.println("No");
                    flag = false;
                    break;
                }
            }
            if (flag) System.out.println("Yes");

        }
    }
}
