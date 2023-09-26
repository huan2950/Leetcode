package exam.meituan.test1;

import java.util.Scanner;

public class problem6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        double sum = 0;
        double[] nums = new double[n];
        for (int i = 0; i < n; i++){
            nums[i] = in.nextDouble();
            sum += nums[i];
        }
        int x = in.nextInt();
        int y = in.nextInt();
        if(x > y){
            int temp = x;
            x = y;
            y = temp;
        }
        double count = 0;
        for (int i = x - 1; i < y - 1; i++){
            count += nums[i];
        }
        System.out.println(Math.min(count,sum - count));
    }
}
