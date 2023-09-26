package acm;

import java.util.Scanner;

public class Array {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int length = in.nextInt();
            if (length == 0)break;
            int[] nums = new int[length];
            int sum = 0;
            for (int i = 0; i < length; i++){
                nums[i] = in.nextInt();
                sum += nums[i];
            }
            int avg = sum / length;
            int res = 0;
            for (int i = 0; i < length; i++){
                if (nums[i] > avg){
                    res += nums[i] - avg;
                }
            }
            System.out.println(res);
            System.out.println();
        }
        in.close();
    }
}
