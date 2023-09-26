package exam.meituan.test1;

import java.util.Scanner;

public class problem5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int i, j;
        if (n % 2 == 1){
            // odd
            System.out.print((n + 1)/2 + " ");
            i = (n - 1)/2;
            j = i + 2;
        }else {
            // even
            i = n / 2;
            j = i + 1;
        }
        while (i >= 0 && j <= n){
            System.out.print(i + " " + j + " ");
            i--;
            j++;
        }
    } 
}
