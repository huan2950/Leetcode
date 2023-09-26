package exam.meituan.test2;

import java.util.Scanner;

public class problem1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long sumPre = 0;
        long sumFormer = 0;
        long sumLatter = 0;
        long pre = in.nextLong();
        long maxMul = 0;
        for (int i = 1; i < n; i++){
            sumPre += pre;
            long cur = in.nextInt();
            if (pre * cur > maxMul){
                maxMul = pre * cur;
                sumLatter = 0;
                sumFormer = sumPre - pre;
            }else{
                sumLatter += cur;
            }
            pre = cur;
        }
        System.out.println(sumFormer + maxMul + sumLatter); 
    }
}
