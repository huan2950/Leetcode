package exam.meituan.test1;

import java.util.Scanner;

public class problem4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0;i < n; i++){
            nums[i] = in.nextInt();
        }
        int x = in.nextInt();
        int y = in.nextInt();
        if (nums[0] == x && nums[1] == y) {
            System.out.println("Yes");
            return;
        }
        if (nums[n-2] == y && nums[n-1] == x){
            System.out.println("Yes");
            return;
        }
        for (int i = 1; i < n - 1; i++){
            if (nums[i] == x && (nums[i-1] == y || nums[i+1] == y)){
                System.out.println("Yes");
                return;
            }
        }
        System.out.println("No");
    }
}
