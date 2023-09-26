package exam.meituan.test1;

import java.util.Scanner;

public class problem8 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        if (n == 1 && m == 1){
            System.out.println(in.nextInt());
            return;
        }
        double[] rowSum = new double[n];
        double[] colSum = new double[m];
        for (int i = 0; i < n; i++){
            double sum = 0;
            for (int j = 0; j < m; j++){
                double num = in.nextDouble();
                if (i == n - 1 && j > 0){
                    colSum[j] += ( colSum[j-1] + num );
                }else{
                    colSum[j] += num;
                }
                sum += num;
            }
            if (i == 0){
                rowSum[i] = sum;
            } else {
                rowSum[i] = rowSum[i-1] + sum;
            }
        }
        double sum = rowSum[n-1];
        double minSub = Integer.MAX_VALUE;
        for(int i = 0; i < n - 1; i++){
            minSub = Math.min(minSub, Math.abs(sum - 2 * rowSum[i]));
        }
        for (int j = 0; j < m - 1; j++){
            minSub = Math.min(minSub,Math.abs(sum - 2 * colSum[j]));
        }
        System.out.println((int)minSub);
    }
}
