package exam.meituan.test3;

import java.util.Scanner;

public class problem3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        long[] bills = new long[m + 1]; 
        for (int i = 0; i < n; i++){
            int k = in.nextInt();
            int money = in.nextInt();
            int avg = 0;
            if (money % k == 0){
                avg = money / k;
            }else {
                avg = money / k + 1;
            }
            for (int j = 1; j < k; j++){
                bills[in.nextInt()] += avg;
            }
        }
        for (int i = 1; i <= m; i++){
            System.out.print(bills[i] + " ");
        }
    }
}
